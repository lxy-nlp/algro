package Algor.Sort;

public class Sorts {
    // 冒泡排序
    public static void bubbleSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }
    //优化的冒泡排序 加入了判断是否正序
    public static void optBubbleSort(int[] arr){
        boolean flag = true; //默认不需要交换
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    flag = false;
                }
            }
            if (flag){
                break;
            }
        }
    }


    //插入排序 前提是被插入的数组有序
    public static void insertSort(int[] arr){
        int n = arr.length;
        if(n<=1) return;
        for(int i = 1;i<n;i++){
            for(int j = i-1;j>=0;j--){
                if(arr[i]<arr[j]){
                    int tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                }

            }
        }
    }
    //选择排序
    public static void selectSort(int[] arr){
        int  n = arr.length;
        for(int i =0;i<n-1;i++){
            int minIndex = i;  //找最值的下标比较合适
            int t =0;
            for(int j= i+1;j<n;j++){
                if(arr[j]<arr[minIndex]){
                    minIndex = j;
                }
            }

            // 交换
            int tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;

        }
    }

    // 希尔排序
    public static void shellSort(Comparable[] arr){
        int n = arr.length;
        int h = 1;
        while(h<n/3) h = 3*h+1; // 初始 增量 h 的确定
        while(h>=1){ // 每一轮减少增量
            for(int i=h;i<n;i++){
                for(int j =i;j>=h&&less(arr[i],arr[j-h]);j-=h){
                    exch(arr,j,j-h);
                }
            }
            h = h/3;
        }
    }

    //some template
    public static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }
    public static boolean isSorted(Comparable[] a){
        for(int i=1;i<a.length;i++){
            if(less(a[i],a[i-1])) return false;
        }
        return true;
    }

    public static void exch(Comparable[] a,int i,int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
