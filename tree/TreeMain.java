package com.shubhaga.algo.trees;

public class TreeMain {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("In-order tree traversal:");
        tree.inOrderTraversal(tree.root);
        System.out.println("\nPre-order tree traversal:");
        tree.preOrderTraversal(tree.root);
        System.out.println("\nPost-order tree traversal:");
        tree.postOrderTraversal(tree.root);
    }
}

class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    public void displayTree() {
        displayTree(root);
    }

    private void displayTree(Node node) {
        if (node == null) {
            return;
        }

        displayTree(node.left);
        System.out.print(node.data + " ");
        displayTree(node.right);
    }

    public void inOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.print(node.data + " ");
        inOrderTraversal(node.right);
    }

    public void preOrderTraversal(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.data + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    public void postOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.data + " ");
    }


}
class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}
