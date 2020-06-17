import java.lang.reflect.Constructor;

class Person{
    private String name;
    //private int age;
    public Person(){

    } //无参构造方法
    public Person(String name){
        this.setName(name);
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String toString(){
        return "姓名"+this.name;
    }
}

public class ReflectDemo {
    public static void main(String[] args){
        fun1();//无参构造
        fun2();//有参构造
    }
    public static void fun1(){
        Class<?> c = null;
        try{
            c= Class.forName("Person");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        Person per = null;
        try{
            per = (Person)c.getDeclaredConstructor().newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        per.setName("李兴华");
        System.out.print(per);
    }

    public static void fun2(){
        Class<?> c = null;
        try{
            c= Class.forName("Person");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        Person per = null;
        Constructor<?> cons[] = null;
        try{
            cons = c.getConstructors();
            per = (Person)cons[1].newInstance("李兴华");
        }catch (Exception e){
            e.printStackTrace();
        }
        // per.setName("李兴华");
        System.out.print(per);
    }
}
