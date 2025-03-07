package geeksforgeeks;

// Definition for a binary tree node


import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeDiameter {

    // Method to calculate the diameter of the binary tree
    public int diameter(TreeNode root) {
        int maxLength = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode current = queue.poll();
            if(current!=null) {
                queue.add(current.left);
                queue.add(current.right);
                int rightHeight = height(current.right);
                int leftHeight = height(current.left);
                maxLength = Math.max(maxLength, rightHeight + leftHeight);
            }
        }

        return maxLength;
    }

    // Helper method to calculate the height of the tree
    private int height(TreeNode node) {
        if (node == null)
            return 0;
        else {
            return 1 + Math.max(height(node.left), height(node.right));
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        BinaryTreeDiameter tree = new BinaryTreeDiameter();

        // Example 1
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        System.out.println(tree.diameter(root1)); // Expected output: 2

        // Example 2
        TreeNode root2 = new TreeNode(10);
        root2.left = new TreeNode(20);
        root2.right = new TreeNode(30);
        root2.left.left = new TreeNode(40);
        root2.left.right = new TreeNode(60);
        System.out.println(tree.diameter(root2)); // Expected output: 3

        // Example 3
        TreeNode root3 = new TreeNode(5);
        root3.left = new TreeNode(8);
        root3.right = new TreeNode(6);
        root3.left.left = new TreeNode(3);
        root3.left.right = new TreeNode(7);
        root3.right.right = new TreeNode(9);
        System.out.println(tree.diameter(root3)); // Expected output: 4
    }
}
