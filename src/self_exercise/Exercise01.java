package self_exercise;

public class Exercise01 {

    private static int[] aux;
    public static void main(String[] args){
        int[] arr = {5,8,3,6,7,9,0};
        bubbleSort(arr);
        printArr(arr);
    }
    public static void bubbleSort(int[] arr){
        int n = arr.length;
        for(int i =1;i<n;i++){
            for(int j=0;j<n-i;j++){
                if(compare(arr[j],arr[j+1])){
                    swap(arr,j,j+1);
                }
            }
        }
    }

    public static void mergeSort(int[] arr){
        int n = arr.length;
        aux = new int[n];
        mergeSort(arr,0,n-1);

    }
    public static void mergeSort(int[] arr,int low,int high){
        if (high<=low) return;
        int  mid = low+(high-low)/2;
        mergeSort(arr,low,mid);
        mergeSort(arr,mid+1,high);


    }
    public static void merge(int[] arr,int low,int mid,int high){
        int i = low,j=mid+1;
        for(int k =0;k<=high;k++){
            aux[k] = arr[k];
        }
        for(int k=low;k<=high;k++){
            if(i>mid) arr[k] = aux[j++];
            if(j>high) arr[k] = aux[i++];
            else if(compare(aux[j],aux[i])) arr[k]=aux[i++];
            else arr[k] = aux[j++];
        }
    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static boolean compare(int a,int b){
        return a > b;
    }
    public static void printArr(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
