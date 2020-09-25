package Algor.Graph;

import Algor.DataStructure.Bag;

import java.util.Stack;

public class Graph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;
    public Graph(int V)
    {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for(int v =0;v<V;v++)
        {
            adj[v] = new Bag<Integer>();
        }
    }

    public Graph(int V,int E)
    {
        this(V);
        if(E < 0) throw new RuntimeException("Number of edges must be postitive");
        for(int i = 0;i < E;i++)
        {
            int v = (int)(Math.random() * V);
            int w = (int)(Math.random() * V);
            addEdge(v,w);
        }
    }

    public Graph(Graph G)
    {
        this(G.V());
        this.E = G.E();
        for(int v = 0;v < G.V();v++)
        {
            Stack<Integer> reverse = new Stack<Integer>();
            for(int w : G.adj[v])
            {
                reverse.push(w);
            }
            for(int w : reverse)
            {
                adj[v].add(w);
            }
        }
    }

    public void addEdge(int v, int w)
    {
        E++;
        adj[v].add(w);
        adj[w].add(v);
    }

    public Iterable<Integer> adj(int v)
    {
        return adj[v];
    }

    public int V()
    {
        return V;
    }
    public int E()
    {
        return E;
    }
}
