package Algor.Search;

public class BinarySearch<Key extends Comparable<Key>,Value> {

    private int  N;
    private Key[] keys;
    private Value[] values;
    public int rank(Key key)
    {
        int low = 0,high=N-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp<0) high = mid-1;
            else if(cmp>0) low=mid+1;
            else return mid;
        }
        return low;
    }
    public Key min(){
        return keys[0];
    }
    public Key max(){
        return keys[N-1];
    }
    public Key select(int k){
        return keys[k];
    }
}
