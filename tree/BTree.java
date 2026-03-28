public class BTree {

    // Node is a class, not a method — defined with "class" keyword
    static class Node {
        int val;
        Node leftNode;
        Node rightNode;

        // constructor has same name as class, no return type
        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(10);
        System.out.println("Node value: " + node1.val);
    }

}
