package Algor.Search;

public class SeperateChainHashST<Key,Value> {
    private int N;
    private int M;

    private SequentialSearchST<Key,Value>[] st;

    public SeperateChainHashST()
    {
        this(997);
    }
    public SeperateChainHashST(int M)
    {
        this.M = M;
        st = (SequentialSearchST<Key,Value>[])new SequentialSearchST[M];
        for(int i= 0;i < M; i++)
        {
            st[i] = new SequentialSearchST();
        }
    }

    public int hash(Key key)
    {
        return (key.hashCode() & 0x7fffff) %M;
    }

    public Value get(Key key)
    {
        return(Value) st[hash(key)].get(key);
    }

    public void put(Key key,Value val)
    {
        st[hash(key)].put(key,val);
    }

    public Iterable<Key> keys()
    {

    }
}
