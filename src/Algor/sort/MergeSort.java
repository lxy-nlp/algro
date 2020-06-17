package Algor.sort;

import static Algor.sort.Template.less;

public class MergeSort {
    private static Comparable[] aux;

    public static void merge(Comparable[] a, int lo, int mid,int hi){
        int i = lo,j = mid+1;
        for(int k = lo;k<=hi;k++){
            aux[k] = a[k];
        }
        for(int k = lo;k<=hi;k++){
            if(i>mid) a[k] = aux[j++];
            else if(j>hi) a[k] = aux[j++];
            else if(less(aux[j],aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    //两种策略
    // 自顶向下
    public static void sort(Comparable[] a){
        sort(a,0,a.length-1);
    }
    public static void sort(Comparable[] a,int low,int high){
        if(high<=low) return;
        int mid = low+(high-low)/2;
        sort(a,low,mid);
        sort(a,mid+1,high);
        merge(a,low,mid,high);
    }

}
