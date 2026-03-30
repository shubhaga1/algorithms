import java.util.Scanner;

 class Btree1 {

    Node root;

    class Node{
        int value;
        Node nodeLeft ;
        Node nodeRight;

        public Node(int value){
            this.value =value;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Btree1 tree = new Btree1();
        tree.populate(scanner);
        tree.display();
    }

    static boolean readBoolean(Scanner scanner) {
        while (true) {
            String input = scanner.next().trim().toLowerCase();
            if (input.equals("true")  || input.equals("yes") || input.equals("y")) return true;
            if (input.equals("false") || input.equals("no")  || input.equals("n")) return false;
            System.out.println("  Invalid input. Please enter yes/no or true/false:");
        }
    }

    // insert the value
    public void populate(Scanner scanner){
        System.out.println("Enter the root Node:");
        int value = scanner.nextInt();
     root = new Node(value);
        populate(scanner, root);
    }

    public void populate(Scanner scanner, Node node){
        System.out.println("Do you want to enter the value of left node" + node.value);
        boolean left = readBoolean(scanner);
        if(left){
            System.out.println("Enter the left Node value:");
            int value = scanner.nextInt();
            node.nodeLeft = new Node(value);
            populate(scanner, node.nodeLeft);
        }
        System.out.println("Do you want to enter the value of right node for " + node.value);

        boolean right = readBoolean(scanner);
        if(right){
            System.out.println("Enter the right Node value:");
            int value = scanner.nextInt();
            node.nodeRight = new Node(value);
            populate(scanner, node.nodeRight);
        }
    }

    public void display(){
        display(root, "");
    }

    private void display(Node node, String indent){
        if(node == null){
            return;
        }
        System.out.println(indent + node.value);
        display(node.nodeLeft,  indent + "\t");
        display(node.nodeRight, indent + "\t");
    }
}