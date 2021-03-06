package Algor.Sort;

public class Template {
    //some template
    public static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }

    public static boolean isSorted(Comparable[] a){
        for(int i=1;i<a.length;i++){
            if(less(a[i],a[i-1]))
                return false;
        }
        return true;
    }

    public static void exch(Comparable[] a,int i,int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
