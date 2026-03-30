/**
 * NodeBasics — What is a Node?
 *
 * A Node is the building block of every tree.
 * Each node holds a value and pointers to left and right children.
 *
 * Visual:
 *         10          ← root node
 *        /  \
 *       5    15       ← child nodes
 *      / \
 *     3   7           ← leaf nodes (no children)
 *
 * Rule in BST:
 *   left child  < parent
 *   right child > parent
 */
class NodeBasics {

    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node(" + value + ")";
        }
    }

    public static void main(String[] args) {
        // Build the tree above manually
        Node root  = new Node(10);
        root.left  = new Node(5);
        root.right = new Node(15);
        root.left.left  = new Node(3);
        root.left.right = new Node(7);

        System.out.println("Root            : " + root);
        System.out.println("Left child      : " + root.left);
        System.out.println("Right child     : " + root.right);
        System.out.println("Left → Left     : " + root.left.left);
        System.out.println("Left → Right    : " + root.left.right);
        System.out.println("Right has left? : " + (root.right.left == null ? "no — leaf node" : root.right.left));

        // BST property check
        System.out.println("\nBST property:");
        System.out.println("  root.left  < root : " + root.left.value  + " < " + root.value + " = " + (root.left.value  < root.value));
        System.out.println("  root.right > root : " + root.right.value + " > " + root.value + " = " + (root.right.value > root.value));
    }
}
