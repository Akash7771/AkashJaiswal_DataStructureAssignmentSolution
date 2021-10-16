package com.greatlearning.ques2;

public class ConvertBinaryToSkewedTree {
    static Node headNode = null;
    static Node prevNode = null;

    class Node{
        int data;
        Node left;
        Node right;
    }

    public Node newNode(int data){
        Node newNode = new Node();
        newNode.data = data;
        newNode.left = null;
        newNode.right = null;

        return newNode;
    }

    public void skewed(Node root){

        if(null == root)return;

        skewed(root.left);

        Node rightNode = root.right;

        if(null == headNode){
            headNode = root;
            root.left = null;
            prevNode = root;
        }else{
            prevNode.right = root;
            root.left = null;
            prevNode = root;
        }

        skewed(rightNode);
    }

    public void traverseRightSkewed(Node root){
        if(null == root)return ;
        System.out.print( root.data +" ");
        traverseRightSkewed(root.right);
    }

    public static void main(String[] args) {
        ConvertBinaryToSkewedTree BSTree = new ConvertBinaryToSkewedTree();
        Node root;
        root = BSTree.newNode(50);
        root.left = BSTree.newNode(30);
        root.right = BSTree.newNode(60);
        root.left.left = BSTree.newNode(10);
        root.left.right = BSTree.newNode(40);

        BSTree.skewed(root);
        BSTree.traverseRightSkewed(headNode);

    }
}
