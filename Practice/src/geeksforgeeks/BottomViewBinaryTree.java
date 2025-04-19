package geeksforgeeks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class BottomViewBinaryTree {

    public ArrayList<Integer> bottomView(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 0));
        TreeMap<Integer, Integer> map = new TreeMap<>();
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> currentPair = queue.poll();
            TreeNode current = currentPair.getKey();
            int hd = currentPair.getValue();

            map.put(hd, current.val);

            if (current.left != null) {
                queue.add(new Pair<>(current.left, hd - 1));
            }
            if (current.right != null) {
                queue.add(new Pair<>(current.right, hd + 1));
            }
        }
        return new ArrayList<>(map.values());
    }

    private static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        private K getKey() {
            return this.key;
        }

        private V getValue() {
            return this.value;
        }
    }

    public static void main(String[] args) {
        // Example 1
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);

        // Example 2
        TreeNode root2 = new TreeNode(10);
        root2.left = new TreeNode(20);
        root2.right = new TreeNode(30);
        root2.left.left = new TreeNode(40);
        root2.left.right = new TreeNode(60);

        BottomViewBinaryTree tree = new BottomViewBinaryTree();

        // Placeholder print statements
        System.out.println(tree.bottomView(root1)); // Expected Output: [3, 1, 2] after implementation
        System.out.println(tree.bottomView(root2)); // Expected Output: [40, 20, 60, 30] after implementation
    }
}
