package geeksforgeeks;

import java.util.ArrayList;

import java.util.*;
import java.util.LinkedList;


public class TopViewBinaryTree {

    /**
     * Method to find the top view of a binary tree.
     *
     * @param root The root of the binary tree.
     * @return An ArrayList containing the nodes in the top view from left to right.
     */
    public static ArrayList<Integer> topView(Nodes root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<Pair<Nodes, Integer>> queue = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        queue.add(new Pair<>(root, 0));
        while (!queue.isEmpty()) {
            Pair<Nodes, Integer> current = queue.poll();
            Nodes currentHead = current.getKey();
            Integer hd = current.getValue();

            if (!map.containsKey(hd)) {
                map.put(hd, currentHead.data);
            }

            if (currentHead.left != null) {
                queue.add(new Pair<>(currentHead.left, hd - 1));
            }
            if (currentHead.right != null) {
                queue.add(new Pair<>(currentHead.right, hd + 1));
            }
        }

        result.addAll(map.values());
        return result;
    }

    private static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }

    }


    // Helper method to build a binary tree from a given array
    private static Nodes buildTree(Integer[] arr, int index) {
        if (index >= arr.length || arr[index] == null) {
            return null;
        }
        Nodes root = new Nodes(arr[index]);
        root.left = buildTree(arr, 2 * index + 1);
        root.right = buildTree(arr, 2 * index + 2);
        return root;
    }

    // Main method to test the implementation with examples
    public static void main(String[] args) {
        // Example 1
        Integer[] arr1 = {1, 2, 3};
        Nodes root1 = buildTree(arr1, 0);
        ArrayList<Integer> result1 = topView(root1);
        System.out.println("Example 1: " + result1); // Expected output: [2, 1, 3]

        // Example 2
        Integer[] arr2 = {10, 20, 30, 40, 60, 90, 100};
        Nodes root2 = buildTree(arr2, 0);
        ArrayList<Integer> result2 = topView(root2);
        System.out.println("Example 2: " + result2); // Expected output: [40, 20, 10, 30, 100]

        // Example 3
        Integer[] arr3 = {1, 2, 3, null, 4, null, null, null, 5, null, 6};
        Nodes root3 = buildTree(arr3, 0);
        ArrayList<Integer> result3 = topView(root3);
        System.out.println("Example 3: " + result3); // Expected output: [2, 1, 3, 6]
    }
}