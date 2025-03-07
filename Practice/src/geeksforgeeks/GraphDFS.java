package geeksforgeeks;

import java.util.ArrayList;

public class GraphDFS {

    // Method to perform DFS traversal of the graph
    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        // Initialize the result list to store the DFS traversal order
        ArrayList<Integer> result ;
        boolean[] visited = new boolean[adj.size()];
        result = DFS(adj, visited, 0);

        return result;
    }

    private ArrayList<Integer> DFS(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int parent) {
        ArrayList<Integer> result = new ArrayList<>();
        visited[parent] = true;
        result.add(parent);
        ArrayList<Integer> list = adj.get(parent);
        for (int n : list) {
            if (!visited[n]) {
                result.addAll(DFS(adj, visited, n));
            }
        }
        return result;
    }

    // Main method for testing
    public static void main(String[] args) {
        // Example 1
        ArrayList<ArrayList<Integer>> adj1 = new ArrayList<>();
        adj1.add(new ArrayList<>() {{
            add(2);
            add(3);
            add(1);
        }});
        adj1.add(new ArrayList<>() {{
            add(0);
        }});
        adj1.add(new ArrayList<>() {{
            add(0);
            add(4);
        }});
        adj1.add(new ArrayList<>() {{
            add(0);
        }});
        adj1.add(new ArrayList<>() {{
            add(2);
        }});

        GraphDFS graphDFS1 = new GraphDFS();
        ArrayList<Integer> result1 = graphDFS1.dfsOfGraph(adj1);
        System.out.println(result1);  // Expected Output: [0, 2, 4, 3, 1]

        // Example 2
        ArrayList<ArrayList<Integer>> adj2 = new ArrayList<>();
        adj2.add(new ArrayList<>() {{
            add(1);
            add(2);
        }});
        adj2.add(new ArrayList<>() {{
            add(0);
            add(2);
        }});
        adj2.add(new ArrayList<>() {{
            add(0);
            add(1);
            add(3);
            add(4);
        }});
        adj2.add(new ArrayList<>() {{
            add(2);
        }});
        adj2.add(new ArrayList<>() {{
            add(2);
        }});

        GraphDFS graphDFS2 = new GraphDFS();
        ArrayList<Integer> result2 = graphDFS2.dfsOfGraph(adj2);
        System.out.println(result2);  // Expected Output: [0, 1, 2, 3, 4]
    }
}