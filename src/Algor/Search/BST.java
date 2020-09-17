package Algor.Search;

import java.util.LinkedList;
import java.util.Queue;

public class BST<Key extends Comparable<Key>,Value> {//Java中的泛型类
    private Node root;
    private class Node
    {
       private Key key;
       private Value val;
       private Node left,right;
       private int N;
       public Node(Key key, Value val,int N)
       {
           this.val = val;
           this.N = N;
       }
       public int size()
       {
           return size(root);
       }
       public int size(Node x)
       {
           if(x == null) return 0;
           return x.N;
       }
       public Value get(Key key)
       {
            return get(root,key);
       }
       public void put(Key key,Value val)
       {
            put(root,key,val);
       }
       public Value get(Node x,Key key)
       {
           if(x == null) return null;
           int cmp = key.compareTo(x.key);
           if(cmp<0) return get(x.left,key);
           else if(cmp>0) return get(x.right,key);
           else return x.val;
       }
       public Node put(Node x,Key key,Value val)
       {
           if(x == null) return new Node(key,val,1);
           int cmp = key.compareTo(x.key);
           if(cmp<0) x.left = put(x.left,key,val);
           else if(cmp>0) x.right = put(x.right,key,val);
           else x.val = val;
           x.N = size(x.left)+size(x.right) +1;//更新的话还需要再+1吗
           return x;
       }
        public void deleteMin()
        {
            root  = deleteMin(root);
        }
        public Node deleteMin(Node x)
        {//找到最小值的节点然后清空
            if(x.left == null) return x.right;
            x.left = deleteMin(x.left);
            x.N = size(x.left) + size(x.right)+1;
            return x;
        }

        public Key select(int k)
        {
            return select(root,k).key;
        }
        public Node select(Node x, int k)
        {
            if(x == null) return null;
            int t = size(x.left);
            if(t>k) return select(x.left,k);
            else if(t<k) return select(x.right,k-t-1);
            else return x;
        }
        public int rank(Key key)
        {
            return rank(key,root);
        }
        public int rank(Key key,Node x)
        {
            if(x == null) return 0;
            int cmp = key.compareTo(x.key);
            if(cmp<0) return rank(key,x.left);
            else if(cmp>0) return 1+size(x.left) + rank(key,x.right);
            else return size(x.left);
        }

        public void delete(Key key)
        {
            root  = delete(root, key);
        }
        public Node delete(Node x, Key key)
        {
            if(x == null) return null;
            int cmp = key.compareTo(x.key);
            if(cmp<0) x.left = delete(x.left,key);
            else if(cmp>0) x.right = delete(x.right,key);
            else
            {
                if(x.right == null) return x.left;
                if(x.left == null) return x.right;
                Node t = x;
                x = min(t.right);
                x.right = deleteMin(t.right);
                x.left = t.left;
            }
            x.N = size(x.left) + size(x.right) +1;
            return x;
        }

        public Key min()
        {
            return min(root).key;
        }
        public Node min(Node x)
        {
            if(x.left == null) return x;
            return min(x.left);
        }

        public Key max()
        {
            return max(root).key;
        }
        public Node max(Node x)
        {
            if(x.left == null) return x;
            return max(x.right);
        }

        //范围查找
        public Iterable<Key> keys()
        {
            return keys(min(),max());
        }
        public Iterable<Key> keys(Key lo,Key hi)
        {
            Queue<Key> queue = new LinkedList<Key>();
            keys(root,queue,lo,hi);
            return queue;
        }
        private void keys(Node x,Queue<Key> queue,Key lo, Key hi)
        {
            if(x == null) return;
            int cmplo = lo.compareTo(x.key);
            int cmphi = hi.compareTo(x.key);
            if(cmplo<0) keys(x.left,queue,lo,hi);
            if(cmphi>0) keys(x.right,queue,lo,hi);
            if(cmplo>=0&&cmphi>=0) queue.add(x.key);
        }
    }
}
