package self_exercise;

public class Execrcise03 {

}

class BinaryTree{
    class BinaryNode{
        private String key;
        private double value;
        private BinaryNode left;
        private BinaryNode right;

        //  此处this的作用是区分成员变量和局部变量
        public BinaryNode(String key,double value)
        {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public double getValue()
        {
            return value; //成员函数是为调用是成员变量,所以没有使用this
        }
    }


    private BinaryNode root;
    private int count;
    public BinaryTree()
    {
        this.root = null;
    }

    public void put(String key, double value)
    {
        BinaryNode newNode = new BinaryNode(key,value);
        if(root == null)
        {
            root = newNode;
            return;
        }
        BinaryNode currentNode = root;
        BinaryNode parentNode = root;
        boolean isLeftChild = true;
        while(currentNode != null)
        {
            if(value < currentNode.getValue())
            {
                parentNode = currentNode;
                currentNode = currentNode.left;
                isLeftChild = true;
            }
            else(value > currentNode.getValue())
            {
                parentNode = currentNode;
                currentNode = currentNode.right;
                isLeftChild = false;
            }
        }

        if(isLeftChild)
            parentNode.left = newNode;
        else
            parentNode.right = newNode;
    }

    //递归 确定好出口
    public BinaryNode put(BinaryNode x, String key, double value)
    {
        BinaryNode newNode = new BinaryNode(key, value);
        if(x == null)
        {
          return newNode;
        }
        if(value < x.value)
        {
            x.left = put(x.left, key, value);
        }
        else if(value > root.value)
        {
            x.right = put(x.right, key, value);
        }
        else x.value = value;
        return x;
    }

}
