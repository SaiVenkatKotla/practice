package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {

    public static void main(String[] args) {
        // Number of nodes
        int V = 6;

        // Edges
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(Arrays.asList(4, 1));
        edges.add(Arrays.asList(4, 0));
        edges.add(Arrays.asList(5, 0));
        edges.add(Arrays.asList(5, 2));
        edges.add(Arrays.asList(2, 3));
        edges.add(Arrays.asList(3, 1));
        /*edges.add(Arrays.asList(0, 1));
        edges.add(Arrays.asList(1, 2));
        edges.add(Arrays.asList(3, 1));
        edges.add(Arrays.asList(3, 2));*/


        // Graph represented as an adjacency list
        List<List<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (List<Integer> i : edges) {
            adj.get(i.get(0)).add(i.get(1));
        }

        topologicalSort(adj, V);
    }

    private static void topologicalSort(List<List<Integer>> adj, int V) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                sortTopologically(stack, visited, adj, i);
            }
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop() + ",");
        }
    }

    private static void sortTopologically(Stack<Integer> stack, boolean[] visited, List<List<Integer>> adj, int i) {
        visited[i] = true;
        for (int n : adj.get(i)) {
            if (!visited[n]) {
                sortTopologically(stack, visited, adj, n);
            }
        }
        stack.push(i);
    }
}
