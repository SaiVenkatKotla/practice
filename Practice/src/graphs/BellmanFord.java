package graphs;

import Algorithms.GraphInputHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BellmanFord {

    static class Edge {
        int from;
        int to;
        int weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    static void bellmanFord(int V, List<Edge> graphs, int source) {
        int[] dist = new int[graphs.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        for (int i = 0; i < V - 1; i++) {
            for (Edge edge : graphs) {
                if (dist[edge.from] != Integer.MAX_VALUE && dist[edge.from] + edge.weight < dist[edge.to]) {
                    dist[edge.to] = dist[edge.from] + edge.weight;
                }
            }
        }

        for (Edge edge : graphs) {
            if (dist[edge.from] != Integer.MAX_VALUE && dist[edge.from] + edge.weight < dist[edge.to]) {
                System.out.println("Graph contains a negative Cycle");
                return;
            }
        }

        System.out.println("Vertices\tDistance from source");
        for(int  i = 0;i<V ;i++){
            System.out.println((i+"  " + dist[i]));
        }

    }


    public static void main(String[] args) {
        int V = 5;
        List<Edge> graph = new ArrayList<>();
        graph.add(new Edge(0, 1, 4));
        graph.add(new Edge(0, 2, 5));
        graph.add(new Edge(1, 2, -3));
        graph.add(new Edge(1, 3, 2));
        graph.add(new Edge(2, 4, 4));
        graph.add(new Edge(3, 4, 3));

        int source = 0;
        bellmanFord(V, graph, source);

    }
}
