package tree;

public class Tree1 {

    // Tree

    // Node (Link list - value and node); (double link list : previous also)
    private class Node {
        private int value;
        private Node leftchild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node=" + value;
        }
    }

    private Node root;
    // Tree (value , leftChild and rightChild)
    // insert (value)

    public void insert(int value) {
        Node node = new Node(value);
        if (root == null) {
            root = node;
            return;
        }
        Node current = root;
        while (true) {
            if (value < current.value) {
                if (null == current.leftchild) {
                    current.leftchild = node;
                    break;
                }
                current = current.leftchild;
            } else {
                if (null == current.rightChild) {
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            }
        }
    }
    // find (value): boolean
    public boolean find(int value){
        Node current = root;
        while(current!= null) {
            if (value < current.value) {
                current = current.leftchild;
            } else if (value > current.value) {
                current = current.rightChild;
            } else {
                return true;
            }
        }
        return false;
    }
    public void traversePreOrder(){
        traversePreOrder(root);
    }

    private void traversePreOrder(Node root){
        if (null ==root){
            return;
        }
        System.out.println(root.value);
        traversePreOrder(root.leftchild);
        traversePreOrder(root.rightChild);
    }
    // var current = root;
    // current = current.leftChild;
    public void traverseInOrder(){
        traverseInOrder(root);
    }

    private void traverseInOrder(Node root){
        if (null ==root){
            return;
        }
        traverseInOrder(root.leftchild);
        System.out.println(root.value);
        traverseInOrder(root.rightChild);
    }

    public void traverseInOrderReverse(){
        traverseInOrderReverse(root);
    }
    private void traverseInOrderReverse(Node root){
        if (null ==root){
            return;
        }
        traverseInOrderReverse(root.rightChild);
        System.out.println(root.value);
        traverseInOrderReverse(root.leftchild);
    }

    public void traversePostOrder(){
        traversePostOrder(root);
    }
    private void traversePostOrder(Node root){
        if (null ==root){
            return;
        }
        traversePostOrder(root.leftchild);
        traversePostOrder(root.rightChild);
        System.out.print(root.value+",");

    }

}
