package Algor.DataStructure;

public class BinaryTree {
    class BinaryNode{
        private int value;
        private BinaryNode left;
        private BinaryNode right;
        public BinaryNode(int value){
            this.value = value;
            this.left = null;
            this.right = null;
        }
        public int getValue(){
            return value;
        }
    }
    private BinaryNode root; //定义树根

    public BinaryTree(){
        this.root = null;
    } //构造函数

    public void put(int value){
        BinaryNode newNode = new BinaryNode(value);
        boolean isLeftChild = true;
            if(root==null){
                root = newNode;
                return;
            }
                BinaryNode currentNode = root;
                BinaryNode parentNode = root;

                while(currentNode != null){
                    parentNode = currentNode;
                    if(value<currentNode.value){
                        currentNode = currentNode.left;
                        isLeftChild = true;
                    }else{
                        currentNode = currentNode.right;
                        isLeftChild = false;
                    }
                }
            if(isLeftChild){
                parentNode.left = newNode;
            }else{
                parentNode.right = newNode;
            }
        }

    public BinaryNode find(int key){
        BinaryNode current = root;
        while(current!=null){
            if(key<current.value){
                if(current.left==null)
                    return current;
                current = current.left;
            }else if(key>current.value){
                current = current.right;
            }else{
               return current;
            }
        }
        return null;
    }


    public void PreOrder(BinaryNode root){
        if(root!=null) {
            System.out.print(root.value+" ");
            PreOrder(root.left);
            PreOrder(root.right);
        }
    }

    public void InOrder(BinaryNode root){
        if(root!=null){
            PreOrder(root.left);
            System.out.print(root.value+" ");
            PreOrder(root.right);
        }
    }

    public void PostOrder(BinaryNode root){
        if(root!=null){
            PostOrder(root.left);
            PostOrder(root.right);
            System.out.print(root.value+" ");
        }
    }

}
