package geeksforgeeks;

// Definition for a binary tree node.

class Solution {
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // Recursively calculate the height of the left and right subtrees
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        // Update the diameter if the path through the current node is longer
        diameter = Math.max(diameter, leftHeight + rightHeight);

        // Return the height of the current node
        return Math.max(leftHeight, rightHeight) + 1;
    }
}

// Helper class to build the tree from the given list representation
class TreeBuilder {
    public static TreeNode buildTree(Integer[] nodes, int index) {
        if (index >= nodes.length || nodes[index] == null) {
            return null;
        }
        TreeNode root = new TreeNode(nodes[index]);
        root.left = buildTree(nodes, 2 * index + 1);
        root.right = buildTree(nodes, 2 * index + 2);
        return root;
    }
}

// Example usage
public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        Integer[] root1 = {1, 2, 3};
        TreeNode tree1 = TreeBuilder.buildTree(root1, 0);
        System.out.println(sol.diameterOfBinaryTree(tree1)); // Output: 2

        // Example 2
        Integer[] root2 = {10, 20, 30, 40, 60};
        TreeNode tree2 = TreeBuilder.buildTree(root2, 0);
        System.out.println(sol.diameterOfBinaryTree(tree2)); // Output: 3

        // Example 3
        Integer[] root3 = {5, 8, 6, 3, 7, null, 9};
        TreeNode tree3 = TreeBuilder.buildTree(root3, 0);
        System.out.println(sol.diameterOfBinaryTree(tree3)); // Output: 4
    }
}
