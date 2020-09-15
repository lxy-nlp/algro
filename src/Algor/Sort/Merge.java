package Algor.Sort;

import static Algor.Sort.Template.less;

public class Merge {
    private static Comparable[] aux;
    public static void sort(Comparable[] a)
    {
        aux = new Comparable[a.length];
        sort(a,0,a.length-1);
    }
    //自顶向下
    public static void sort(Comparable[] a, int lo, int hi)
    {
        if(hi <= lo) return;
        int mid = (lo + hi) / 2;
        sort(a, lo, mid);
        sort(a, mid+1,hi);
        merge(a, lo, mid, hi);
    }

    //原地归并
    public static void merge(Comparable[] a, int lo, int mid,int hi){
        int i = lo,j = mid+1;
        for(int k = lo;k<=hi;k++){
            aux[k] = a[k];//先用一个辅助数组将原数组存储下来
        }
        for(int k = lo;k<=hi;k++){
            if(i>mid) a[k] = aux[j++]; //左半部分已经合并完成
            else if(j>hi) a[k] = aux[j++];//右半部分已经合并完成
            else if(less(aux[j],aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }
    //自底向上
    public static void sortBU(Comparable[] a)
    {
        int N = a.length;
        aux = new Comparable[N];
        for(int sz = 1;sz<N; sz *= 2)
            for(int lo = 0;lo < N-sz; lo += 2 * sz)
                merge(a, lo,lo+sz-1,Math.min(lo + 2 *sz -1, N - 1));
    }
}
