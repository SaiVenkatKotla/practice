package geeksforgeeks;

import java.util.Arrays;
import java.util.List;

import java.util.*;

public class CycleDetection {

    /**
     * Checks if the graph contains a cycle using DFS.
     *
     * @param adj adjacency list of the graph
     * @param V   number of vertices
     * @return 1 if there is a cycle, otherwise 0
     */
    public static int isCycle(List<List<Integer>> adj, int V) {
        boolean[] visited = new boolean[V];

        // Check for cycles in all components of the graph
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, visited, adj)) {
                    return 1; // Cycle detected
                }
            }
        }
        return 0; // No cycle
    }

    /**
     * Helper method for DFS traversal.
     *
     * @param node     the current node
     * @param parent   the parent node of the current node
     * @param visited  the visited array
     * @param adj      adjacency list of the graph
     * @return true if a cycle is detected, otherwise false
     */
    private static boolean dfs(int node, int parent, boolean[] visited, List<List<Integer>> adj) {
        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, node, visited, adj)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // Example 1
        List<List<Integer>> adj1 = Arrays.asList(
                Arrays.asList(1),           // Node 0
                Arrays.asList(0, 2, 4),     // Node 1
                Arrays.asList(1, 3),        // Node 2
                Arrays.asList(2, 4),        // Node 3
                Arrays.asList(1, 3)         // Node 4
        );
        System.out.println(isCycle(adj1, adj1.size())); // Output: 1

        // Example 2
        List<List<Integer>> adj2 = Arrays.asList(
                Arrays.asList(),            // Node 0
                Arrays.asList(2),           // Node 1
                Arrays.asList(1, 3),        // Node 2
                Arrays.asList(2)            // Node 3
        );
        System.out.println(isCycle(adj2, adj2.size())); // Output: 0
    }
}

