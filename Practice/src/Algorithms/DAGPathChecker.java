package Algorithms;

import java.util.*;
import java.util.stream.IntStream;

public class DAGPathChecker {
    private int vertices;
    private HashMap<Integer, ArrayList<Integer>> adjacencyList;

    public DAGPathChecker(int v) {
        this.vertices = v;
        adjacencyList = new HashMap<>();
        for (int i = 0; i < v; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }
    }

    private void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);
    }

    private boolean doesPathExist(int start, int end){
        boolean flag = false;
        if (start == end)
            return true;
        for(int n:adjacencyList.get(start)){
            flag = flag || doesPathExist(n,end);
        }
        return flag;
    }

    // Main method to define and test different examples
    public static void main(String[] args) {

        // Example 1
        DAGPathChecker graph1 = new DAGPathChecker(5);
        graph1.addEdge(0, 1);
        graph1.addEdge(1, 2);
        graph1.addEdge(2, 3);
        graph1.addEdge(3, 4);
        System.out.println("Example 1: Path from 0 to 4: " + graph1.doesPathExist(0, 4));

        // Example 2
        DAGPathChecker graph2 = new DAGPathChecker(4);
        graph2.addEdge(0, 1);
        graph2.addEdge(2, 3);
        System.out.println("Example 2: Path from 0 to 3: " + graph2.doesPathExist(0, 3));

        // Example 3
        DAGPathChecker graph3 = new DAGPathChecker(6);
        graph3.addEdge(0, 1);
        graph3.addEdge(0, 2);
        graph3.addEdge(1, 3);
        graph3.addEdge(2, 3);
        graph3.addEdge(3, 4);
        graph3.addEdge(3, 5);
        System.out.println("Example 3: Path from 0 to 5: " + graph3.doesPathExist(0, 5));

        // Example 4
        DAGPathChecker graph4 = new DAGPathChecker(5);
        graph4.addEdge(0, 1);
        graph4.addEdge(1, 2);
        graph4.addEdge(2, 3);
        graph4.addEdge(3, 4);
        System.out.println("Example 4: Path from 2 to 2: " + graph4.doesPathExist(2, 2));

        // Example 5
        DAGPathChecker graph5 = new DAGPathChecker(5);
        graph5.addEdge(0, 1);
        graph5.addEdge(1, 3);
        graph5.addEdge(3, 4);
        graph5.addEdge(1, 4);
        System.out.println("Example 5: Path from 0 to 4: " + graph5.doesPathExist(0, 4));

        // Add more examples as needed...
    }
}
