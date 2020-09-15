package Algor.Sort;
import static Algor.Sort.Template.exch;
import static Algor.Sort.Template.less;
public class QuickSort {
    public static void quickSort(Comparable[] arr){
        quickSort(arr,0,arr.length-1);
    }
    public static void quickSort(Comparable[] arr,int low ,int high){
        if(high<=low) return;
        int j = partition(arr,low,high);
        quickSort(arr,low,j-1);
        quickSort(arr,j+1,high);
    }
    public static int partition(Comparable[] a,int low,int high){
        int i = low,j = high+1;
        Comparable v = a[low];
        while(true){
            while(less(a[++i],v)) if(i==high) break; //在左边找到比基准值大的
            while(less(v,a[--j])) if(j==low) break;//在右边找到比基准值小的
            if(i>=j) break;
            exch(a,i,j);//交换这两个数
        }
        exch(a,low,j); //将基准值放入合适的位置
        return j;
    }
}
