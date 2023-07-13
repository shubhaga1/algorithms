package com.shubhaga.algo.trees;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InsertTree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Scanner scanner = new Scanner(System.in);
        populateTree(tree, scanner);
        tree.inOrderTraversal(tree.root);
    }

    private static void populateTree(BinaryTree tree, Scanner scanner) {
        System.out.println("Enter the root value");
        tree.root = new Node(scanner.nextInt());
        populateNode(tree.root, scanner);
    }

    private static void populateNode(Node node, Scanner scanner) {
        System.out.println("Do you want to enter the left child of " + node.data + "? (true/false)");
        boolean shouldEnterLeft = getValidBoolean(scanner);
        if (shouldEnterLeft) {
            System.out.println("Enter the node value:");
            node.left = new Node(getValidInput(scanner));
            populateNode(node.left, scanner);
        }

        System.out.println("Do you want to enter the right child of " + node.data + "? (true/false)");
        boolean shouldEnterRight = getValidBoolean(scanner);
        if (shouldEnterRight) {
            System.out.println("Enter the node value:");
            node.right = new Node(getValidInput(scanner));
            populateNode(node.right, scanner);
        }
    }

    private static int getValidInput(Scanner scanner) {
        int value;
        while (true) {
            try {
                value = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("\tInvalid input type (must be an integer)");
                scanner.nextLine();  // Clear invalid input from scanner buffer.
            }
        }
        return value;
    }

    private static boolean getValidBoolean(Scanner scanner) {
        boolean value;
        while (true) {
            try {
                value = scanner.nextBoolean();
                break;
            } catch (InputMismatchException e) {
                System.out.println("\tInvalid input type (must be a boolean)");
                scanner.nextLine();  // Clear invalid input from scanner buffer.
            }
        }
        return value;
    }

}

