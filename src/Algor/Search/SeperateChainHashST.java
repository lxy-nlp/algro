package Algor.Search;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        Queue<Key> queue = new LinkedList<Key>();
        for(int i = 0; i < M; i++)
        {
            for(Key key:st[i].keys())
                queue.add(key);
        }
        return queue;
    }

    public void delete(Key key)
    {
        int i = hash(key);
        if(st[i].contains(key))
            N--;
        st[i].delete(key);
    }
    public boolean contains(Key key)
    {
        return get(key) != null;
    }

    public int size()
    {
        return N;
    }

    public boolean isEmpty()
    {
        return size() == 0;
    }
}
