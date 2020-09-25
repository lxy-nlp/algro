package Algor.Graph;

public class DeepFirstSearch {
    public boolean[] marked;
    private int count;

    public DeepFirstSearch(Graph G, int s)
    {
        marked = new boolean[G.V()];
        dfs(G,s);
    }

    public void dfs(Graph G,int v)
    {
        marked[v] =true;
        for(int w : G.adj(v))
        {
            if(!marked[w])
            {
                dfs(G,w);
            }
        }
    }

    public boolean marked(int v)
    {
        return marked[v];
    }

    public int count()
    {
        return count;
    }

}
