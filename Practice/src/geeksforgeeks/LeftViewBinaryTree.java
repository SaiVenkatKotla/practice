package geeksforgeeks;

import java.util.ArrayList;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}

public class LeftViewBinaryTree {

    public ArrayList<Integer> leftView(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            // Add the first node of each level to the result
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();

                if (i == 0) {
                    result.add(currentNode.data);
                }

                // Add left and right children to the queue
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        LeftViewBinaryTree solution = new LeftViewBinaryTree();

        // Example 1
        TreeNode root1 = buildTree(new Integer[]{1, 2, 3, 4, 5, null, null});
        System.out.println(solution.leftView(root1)); // Expected output: [1, 2, 4]

        // Example 2
        TreeNode root2 = buildTree(new Integer[]{1, 2, 3, null, null, 4, null, null, 5, null, null});
        System.out.println(solution.leftView(root2)); // Expected output: [1, 2, 4, 5]

        // Example 3
        TreeNode root3 = buildTree(new Integer[]{null});
        System.out.println(solution.leftView(root3)); // Expected output: []
    }

    // Helper method to build a binary tree from an array representation
    public static TreeNode buildTree(Integer[] array) {
        if (array == null || array.length == 0 || array[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(array[0]);
        int index = 1;
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);

        while (!queue.isEmpty() && index < array.length) {
            TreeNode currentNode = queue.remove(0);

            if (index < array.length && array[index] != null) {
                currentNode.left = new TreeNode(array[index]);
                queue.add(currentNode.left);
            }
            index++;

            if (index < array.length && array[index] != null) {
                currentNode.right = new TreeNode(array[index]);
                queue.add(currentNode.right);
            }
            index++;
        }

        return root;
    }
}

