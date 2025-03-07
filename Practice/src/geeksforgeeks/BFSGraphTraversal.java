package geeksforgeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class BFSGraphTraversal {

    // Method to perform BFS on the graph
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        Deque<Integer> deque = new LinkedList<>();
        deque.offer(0);
        ArrayList<Integer> list = bFS(visited, deque, 0, adj);
        return list;
    }

    public ArrayList<Integer> bFS(boolean[] visited, Deque<Integer> deque, int i, ArrayList<ArrayList<Integer>> adj) {
        visited[i] = true;
        ArrayList<Integer> nodes = adj.get(i);
        ArrayList<Integer> result = new ArrayList<>();
        deque.addAll(nodes);
        result.add(deque.pollFirst());
        while (!deque.isEmpty()) {
            if (!visited[deque.peekFirst()]) {
                result.addAll(bFS(visited, deque, deque.peekFirst(), adj));
            } else {
                deque.pollFirst();
            }
        }
        return result;
    }

    // Main method to test the bfsOfGraph method with example inputs
    public static void main(String[] args) {
        BFSGraphTraversal graphTraversal = new BFSGraphTraversal();

        // Example 1
        ArrayList<ArrayList<Integer>> adj1 = new ArrayList<>();
        adj1.add(new ArrayList<>(Arrays.asList(2, 3, 1)));
        adj1.add(new ArrayList<>(Arrays.asList(0)));
        adj1.add(new ArrayList<>(Arrays.asList(0, 4)));
        adj1.add(new ArrayList<>(Arrays.asList(0)));
        adj1.add(new ArrayList<>(Arrays.asList(2)));
        System.out.println("BFS Traversal (Example 1): " + graphTraversal.bfsOfGraph(5, adj1));

        // Example 2
        ArrayList<ArrayList<Integer>> adj2 = new ArrayList<>();
        adj2.add(new ArrayList<>(Arrays.asList(1, 2)));
        adj2.add(new ArrayList<>(Arrays.asList(0, 2)));
        adj2.add(new ArrayList<>(Arrays.asList(0, 1, 3, 4)));
        adj2.add(new ArrayList<>(Arrays.asList(2)));
        adj2.add(new ArrayList<>(Arrays.asList(2)));
        System.out.println("BFS Traversal (Example 2): " + graphTraversal.bfsOfGraph(5, adj2));

        // Example 3
        ArrayList<ArrayList<Integer>> adj3 = new ArrayList<>();
        adj3.add(new ArrayList<>(Arrays.asList(1)));
        adj3.add(new ArrayList<>(Arrays.asList(0, 2, 3)));
        adj3.add(new ArrayList<>(Arrays.asList(1)));
        adj3.add(new ArrayList<>(Arrays.asList(1, 4)));
        adj3.add(new ArrayList<>(Arrays.asList(3)));
        System.out.println("BFS Traversal (Example 3): " + graphTraversal.bfsOfGraph(5, adj3));
    }
}

