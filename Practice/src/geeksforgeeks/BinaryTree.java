package geeksforgeeks;

import java.util.*;
import java.util.LinkedList;

class BinaryTree {

    // Node definition
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Method to check if a binary tree is height-balanced
    public boolean isBalanced(Node root) {
        return checkHeight(root) != -1;
    }

    // Helper method to check height and balance
    private int checkHeight(Node node) {
        if (node == null) {
            return 0; // Height of an empty tree is 0
        }

        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) return -1; // Left subtree is not balanced

        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) return -1; // Right subtree is not balanced

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // Current node is not balanced
        }

        return Math.max(leftHeight, rightHeight) + 1; // Return height of the current node
    }

    // Helper method to build a tree from an array representation (for testing)
    public Node buildTree(Integer[] arr) {
        if (arr == null || arr.length == 0) return null;

        Node root = new Node(arr[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            Node current = queue.poll();

            if (arr[i] != null) {
                current.left = new Node(arr[i]);
                queue.add(current.left);
            }
            i++;

            if (i < arr.length && arr[i] != null) {
                current.right = new Node(arr[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }

    // Test examples
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Example 1
        Integer[] example1 = {1, 2, null, null, 3};
        Node root1 = tree.buildTree(example1);
        System.out.println("Example 1: " + tree.isBalanced(root1)); // Output: false

        // Example 2
        Integer[] example2 = {10, 20, 30, 40, 60};
        Node root2 = tree.buildTree(example2);
        System.out.println("Example 2: " + tree.isBalanced(root2)); // Output: true

        // Example 3
        Integer[] example3 = {1, 2, 3, 4, null, null, null, 5};
        Node root3 = tree.buildTree(example3);
        System.out.println("Example 3: " + tree.isBalanced(root3)); // Output: false
    }
}
