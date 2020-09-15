package Algor.DataStructure;

import java.util.ArrayList;
import java.util.Scanner;

public class GenericTree {
    private class Node{
        int data;
        ArrayList<Node> child = new ArrayList<>();
    }
    private Node root;
    private int size;
    public GenericTree(){
        Scanner sc = new Scanner(System.in);
        root = create_treeG(null,0,sc);
    }

    private Node create_treeG(Node node,int childindex,Scanner sc){
        if(node==null){
            System.out.println("Enter root's data");
        }else{
            System.out.println("Enter data of parent index"+node.data+" "+childindex);
        }
        node = new Node();
        node.data = sc.nextInt();
        System.out.println("number of children");
        int num = sc.nextInt();
        for(int i=0;i<num;i++){
            Node child = create_treeG(node,i,sc);
            size++;
            node.child.add(child);
        }
        return node;
    }
    public void display(){
        display(root);
    }
    public void display(Node parent){
        System.out.print(parent.data+"=>");
        for(int i=0;i<parent.child.size();i++){
            System.out.print(parent.child.get(i).data+" ");
        }
        System.out.println(".");
        for(int i = 0;i<parent.child.size();i++){
            display(parent.child.get(i));
        }
    }
}
