package geeksforgeeks;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

// User function Template for Java
class Nodes {
    int data;
    Nodes left, right;

    public Nodes(int d) {
        data = d;
        left = right = null;
    }
}

public class BoundaryTraversal {

    /**
     * Method to perform boundary traversal of a binary tree.
     *
     * @param nodes The root of the binary tree.
     * @return An ArrayList containing the nodes in boundary traversal order.
     */
    public ArrayList<Integer> boundaryTraversal(Nodes nodes) {
        ArrayList<Integer> result = new ArrayList<>();
        if (nodes == null)
            return result;
        if (!isLeaf(nodes))
            result.add(nodes.data);

        addLeftBoundary(nodes.left, result);

        addLeaves(nodes, result);

        addRightBoundary(nodes.right, result);
        return result; // Placeholder return value
    }

    public void addLeftBoundary(Nodes nodes, ArrayList<Integer> result) {
        if (nodes == null || isLeaf(nodes))
            return;

        result.add(nodes.data);
        if (nodes.left != null) {
            addLeftBoundary(nodes.left, result);
        } else {
            addLeftBoundary(nodes.right, result);
        }
    }

    public void addLeaves(Nodes nodes, ArrayList<Integer> result) {
        if (nodes == null)
            return;

        if (isLeaf(nodes)) {
            result.add(nodes.data);
        }
        addLeaves(nodes.left, result);
        addLeaves(nodes.right, result);
    }

    public void addRightBoundary(Nodes nodes, ArrayList<Integer> result) {
        if (nodes == null || isLeaf(nodes))
            return;

        if (nodes.right != null)
            addRightBoundary(nodes.right, result);
        else
            addRightBoundary(nodes.left, result);

        result.add(nodes.data);
    }

    public boolean isLeaf(Nodes nodes) {
        return nodes != null && nodes.right == null && nodes.left == null;
    }

    // Main method to test the implementation with examples
    public static void main(String[] args) {
        BoundaryTraversal solution = new BoundaryTraversal();

        // Example 1
        Nodes root1 = new Nodes(1);
        root1.left = new Nodes(2);
        root1.right = new Nodes(3);
        root1.left.left = new Nodes(4);
        root1.left.right = new Nodes(5);
        root1.right.left = new Nodes(6);
        root1.right.right = new Nodes(7);
        root1.left.right.left = new Nodes(8);
        root1.left.right.right = new Nodes(9);

        ArrayList<Integer> result1 = solution.boundaryTraversal(root1);
        System.out.println("Example 1: " + result1); // Expected output: [1, 2, 4, 8, 9, 6, 7, 3]

        // Example 2
        Nodes root2 = new Nodes(1);
        root2.left = new Nodes(2);
        root2.left.left = new Nodes(4);
        root2.left.right = new Nodes(9);
        root2.left.left.left = new Nodes(6);
        root2.left.left.right = new Nodes(5);
        root2.left.right.right = new Nodes(3);
        root2.left.right.right.left = new Nodes(7);
        root2.left.right.right.right = new Nodes(8);

        ArrayList<Integer> result2 = solution.boundaryTraversal(root2);
        System.out.println("Example 2: " + result2); // Expected output: [1, 2, 4, 6, 5, 7, 8]

        // Example 3
        Nodes root3 = new Nodes(1);
        root3.right = new Nodes(2);
        root3.right.right = new Nodes(3);
        root3.right.right.right = new Nodes(4);

        ArrayList<Integer> result3 = solution.boundaryTraversal(root3);
        System.out.println("Example 3: " + result3); // Expected output: [1, 4, 3, 2]
    }
}
