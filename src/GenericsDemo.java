// <T> 的意思是声明这是一个泛型
// 泛型类
class Point<T>{
    private T var;
    // 泛型中的构造方法
    public Point(T var){
        this.var = var;
    }
    public T getVar(){
        return var;
    }
    public void setVar(T var){
        this.var = var;
    }
}
//指定多个泛型
class NotePad<K,V>{
    private K key;
    private V value;
    public K getKey(){
        return key;
    }
    public void setKey(K key){
        this.key = key;
    }
    public V getValue(){
        return value;
    }
    public void setValue(K key){
        this.value = value;
    }
}

//使用通配符 ？
class Info<T>{
    private T var;
    public T getVar(){
        return var;
    }
    public void setVar(T var){
        this.var = var;
    }
    public String toString(){
        return var.toString();
    }

}

// 泛型接口
interface Infor<T>{
    public T getVar();
}

class Informpl<T> implements Infor<T>{
    private T var;
    public void setVar(T var){
        this.var = var;
    }
    public T getVar(){
        return this.var;
    }
    public Informpl(T var){
        this.setVar(var);
    }
}

//泛型方法
class Demo{
    public <T> T fun(T t){
        return t;
    }
}

public class GenericsDemo {
    public static void main(String args[]){
        Info<Integer> i1 = new Info<Integer>();
        Info<Float> i2 = new Info<Float>();
        i1.setVar(30);
        i2.setVar(20.0f);
    }
    //泛型上限
    public static void fun1(Info<? extends Number> temp){ //接受Number及其子类
        System.out.print(temp+"、");
    }
    //泛型下限
    public static void fun2(Info<? super String> temp){ //只接受String及其父类
        System.out.print("内容："+temp);
    }
    // 泛型中的向上转型和向下转型会出错

    public static <T extends Number> Info<T> fun3(T param){
        Info<T> temp = new Info<T>();
        temp.setVar(param);
        return temp;
        //如果使用泛型方法返回泛型类实例，那么必须在返回方法中明确指定泛型标识
    }
    //public static <? extends Number> Info<? extends Number> fun4(? param){

    //}
}
