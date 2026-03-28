package tree;

public class Main {
    public static void main(String[] args) {
        Tree1 tree = new Tree1();
        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);
//        System.out.println(tree.find(8));
//        System.out.println(tree.find(81));
//        System.out.println(tree.find(18));
//        System.out.println(tree.find(1));
//        tree.traversePreOrder();
//        tree.traverseInOrder();
//        tree.traverseInOrderReverse();
        tree.traversePostOrder();
    }
}
