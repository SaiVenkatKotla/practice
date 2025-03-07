package Algorithms;

import java.util.*;

// Class to represent a graph
class Graph {
    private int vertices; // Number of vertices
    private LinkedList<Integer>[] adjacencyList; // Adjacency list

    // Constructor
    Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    // Method to add an edge
    void addEdge(int source, int destination) {
        adjacencyList[source].add(destination); // Add destination to source's list
        adjacencyList[destination].add(source); // For undirected graph
    }

    // DFS utility method
    private void DFSUtil(int vertex, boolean[] visited) {
        // Mark the current node as visited
        visited[vertex] = true;
        System.out.print(vertex + " ");

        // Recur for all adjacent vertices
        for (int adjacent : adjacencyList[vertex]) {
            if (!visited[adjacent]) {
                DFSUtil(adjacent, visited);
            }
        }
    }

    // Method to perform DFS traversal
    void DFS(int startVertex) {
        // Initially mark all vertices as not visited
        boolean[] visited = new boolean[vertices];

        // Call the recursive helper function
        DFSUtil(startVertex, visited);

        // For disconnected graph, perform DFS for all unvisited vertices
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                DFSUtil(i, visited);
            }
        }
    }
}


public class DepthFirstSearch {
    public static void main(String[] args) {
        Graph graph = new Graph(6);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);

        System.out.println("Depth First Search starting from vertex 0:");
        graph.DFS(0);
    }
}
