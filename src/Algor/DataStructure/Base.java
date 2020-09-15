package Algor.DataStructure;
import java.util.*;

public class Base {
    public static void main(String[] args){
//        Scanner input = new Scanner(System.in);
//        String str = input.next();
//        System.out.println(str);
//        String[] nums = str.split(",");
//        if(nums[0]==nums[1]&&nums[1]==nums[2]){
//            System.out.println("equal");
//        }
//        else{
//            System.out.println("not");
//        }

        // check(0.4,0.8);
        // checkPrint();
        // transBinary(123);
        // fgprint();
        System.out.println(Math.log10(computeLn(5)));
        System.out.println(computeLn(5));
    }
    public static void check(double x,double y){
        if(x>=0&&x<=1&&y>=0&&y<=1){
            System.out.print("true");
        }else{
            System.out.print("False");
        }
    }
    public static void checkPrint(){
        System.out.println("b");
        System.out.println('b'+'c'); //字母转换成数字
        System.out.println((char)('a'+4)); //数字转换成字母
    }
    public static void transBinary(int number){
//        String s = Integer.toBinaryString(number);
//        System.out.println(s);
        String s = "";
        for(int n = number;n>0;n/=2){
            s += (n%2);
        }
        System.out.print(s);
    }
    public static void fgprint(){ //本质是斐波那契数列
        int f=0;
        int g=1;
        for(int i =0;i<=15;i++){
            System.out.println(f);
            f= f+g;
            g = f-g;
        }

    }
    public static long  Fibonacci(int n){
        if(n<1){
            return -1;
        }
        if(n==1||n==2) {
            return 1;
        }
        long[] arr = new long[n];
        arr[0] = arr[1] =1;
        for(int i =2;i<n;i++){
            arr[i] = arr[i-2]+arr[i-1];
        }
        return arr[n-1];
    }

    public static long fibonaccifor(int n){
        if(n<1){
            return -1;
        }
        if(n==1||n==2) {
            return 1;
        }
        long a =1l,b=1l,c=0l;
        for(int i =0;i<n-2;i++){
            c= a+b;
            a = b;
            b = c;
        }
        return c;
    }
    public static long computeLn(int n){
        if (n<0){
            return -1;
        }
        if(n==1){
            return 1;
        }
        Long product = n*computeLn(n-1);
        return product;
    }

    public static void printScore(){
        System.out.println("please input data");
        HashMap score = new HashMap();
        while(true){
            Scanner input = new Scanner(System.in);
            String str = input.next();
            if(str!="end"){


            }

        }
    }

    // 二分查找法，要求被查找的数组是有序的
    public static int BinarySearch(int key,int[] a){
        int low = 0 ;
        int high = a.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if (key<a[mid]) high = mid-1;
            else if(key>a[mid]) low = mid+1;
            else return mid;
        }
        return -1;
    }

// 背包 队列 栈
    /*
     * 背包 只进不出
     * */

    public static void bag(){
        Bag<Double> numbers;
    }
}

class Bag<Item> implements Iterable<Item> {
    private Node<Item> first;
    private int n;
    private static class Node<Item>{
        private Item item;
        private Node<Item> next;
    }

    public Bag() {
        first = null;
        n = 0;

    }

    public void add(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    public boolean isEmpty() {
        return first==null;

    }

    public int size(){
        return n;
    }

    public Iterator<Item> iterator(){
        return new ListIterator<Item>(first);
    }

    private class ListIterator<Item> implements Iterator<Item>
    {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}





