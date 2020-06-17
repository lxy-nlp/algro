class MyThread extends Thread{
    private String name;
    public MyThread(String name){
        this.name = name;
    }
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println(name+"运行 i="+i);
        }
    }
};

class AnotherThread implements Runnable{
    private String name;
    public AnotherThread(String name){
        this.name = name;
    }
    public void run(){
        for(int i=0;i<10;i++){
            System.out.print(name+"运行，i="+i);
        }
    }
}
public class ThreadDemo{
    public static void main(String args[]){
        MyThread mt1 = new MyThread("线程A");
        MyThread mt2 = new MyThread("线程B");
        mt1.start();
        mt2.start();

        AnotherThread at1 = new AnotherThread("C");
        AnotherThread at2 = new AnotherThread("D");
        Thread t1 = new Thread(at1);
        Thread t2 = new Thread(at2);
        t1.start();
        t2.start();

    }
}