import java.util.Scanner;

class Btree1 {

    Node root;

    class Node {
        int value;
        Node nodeLeft;
        Node nodeRight;

        Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Btree1 tree = new Btree1();
        tree.populate(scanner);
        tree.display();
    }

    private static boolean readBoolean(Scanner scanner) {
        while (true) {
            String input = scanner.next().trim().toLowerCase();
            if (input.equals("true")  || input.equals("yes") || input.equals("y")) return true;
            if (input.equals("false") || input.equals("no")  || input.equals("n")) return false;
            System.out.println("Invalid input. Please enter yes/no or true/false:");
        }
    }

    public void populate(Scanner scanner) {
        System.out.println("Enter the root node:");
        int value = scanner.nextInt();
        root = new Node(value);
        populate(scanner, root);
    }

    public void populate(Scanner scanner, Node node) {
        System.out.println("Add left child for " + node.value + "? (yes/no):");
        if (readBoolean(scanner)) {
            System.out.println("Enter left node value:");
            node.nodeLeft = new Node(scanner.nextInt());
            populate(scanner, node.nodeLeft);
        }
        System.out.println("Add right child for " + node.value + "? (yes/no):");
        if (readBoolean(scanner)) {
            System.out.println("Enter right node value:");
            node.nodeRight = new Node(scanner.nextInt());
            populate(scanner, node.nodeRight);
        }
    }

    public void display() {
        display(root, "");
    }

    private void display(Node node, String indent) {
        if (node == null) {
            return;
        }
        System.out.println(indent + node.value);
        display(node.nodeLeft,  indent + "\t");
        display(node.nodeRight, indent + "\t");
    }
}
