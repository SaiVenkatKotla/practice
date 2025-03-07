package Algorithms;

import java.util.*;


public class GraphInputHandler {
    public static class Graph {
        int vertices;
        private LinkedList<Integer>[] adjacencyList; // Adjacency list

        // Constructor
        Graph(int vertices) {
            this.vertices = vertices;
            adjacencyList = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++) {
                adjacencyList[i] = new LinkedList<>();
            }
        }

        // Add an edge to the graph
        void addEdge(int source, int destination) {
            adjacencyList[source].add(destination); // Add destination to source's list
            adjacencyList[destination].add(source); // For undirected graph
        }

        // Display graph details
        /*public void printGraph() {
            System.out.println("Number of vertices: " + vertices);
            System.out.println("Edges:");
            for (int[] edge : edges) {
                System.out.println(edge[0] + " → " + edge[1]);
            }
        }*/

        public ArrayList<ArrayList<Integer>> getConnectedComponent() {
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            boolean[] visited = new boolean[vertices];

            for (int i = 0; i < vertices; i++) {
                ArrayList<Integer> result1 = new ArrayList<>();
                if (!visited[i]) {
                    result1 = DFS(visited, i);
                    result.add(result1);
                }
            }

            return result;
        }

        public ArrayList<Integer> DFS(boolean[] visited, int i) {
            ArrayList<Integer> result1 = new ArrayList<>();
            visited[i] = true;
            for (Integer n : adjacencyList[i]){
                if(!visited[n])
                    result1.add(n);
            }
            return result1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of test cases
        System.out.print("Enter the number of test cases: ");
        int testCases = Integer.parseInt(scanner.nextLine());

        List<Graph> testGraphs = new ArrayList<>();

        for (int t = 0; t < testCases; t++) {
            System.out.println("\nTest Case " + (t + 1) + ":");

            // Input number of vertices and edges
            System.out.print("Enter the number of vertices (N): ");
            int vertices = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter the number of edges (M): ");
            int edgesCount = Integer.parseInt(scanner.nextLine());

            // Create a graph
            Graph graph = new Graph(vertices);

            System.out.println("Enter the edges (source and destination):");
            for (int i = 0; i < edgesCount; i++) {
                String[] edgeInput = scanner.nextLine().split("\\s+");
                int source = Integer.parseInt(edgeInput[0]);
                int destination = Integer.parseInt(edgeInput[1]);
                graph.addEdge(source, destination);
            }

            // Add the graph to the list of test cases
            testGraphs.add(graph);
        }

        for (int t = 0; t < testCases; t++) {
            ArrayList<ArrayList<Integer>> result = testGraphs.get(t).getConnectedComponent();
            for(ArrayList<Integer> list : result){
                System.out.println("list");
                System.out.println(list);
            }
        }
        // Close scanner
        scanner.close();
    }
}

