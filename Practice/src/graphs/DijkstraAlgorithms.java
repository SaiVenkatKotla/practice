package graphs;

import java.util.*;
import java.util.stream.IntStream;

public class DijkstraAlgorithms {


    static class Edge{
        int to;
        int dist;

        public Edge(int to, int dist){
            this.to  = to;
            this.dist = dist;
        }
    }

    public static void dijkstra(List<List<Edge>> graph, int src){
        int n = graph.size();
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, src});

        while (!pq.isEmpty()){
            int[] current = pq.poll();
            int currentDist = current[0];
            int u = current[1];

            if (currentDist > dist[u]) continue;

            for(Edge edge : graph.get(u)){
                int v = edge.to;
                int weight = edge.dist;
                if(dist[u] + weight  < dist[v]){
                    dist[v] = dist[u] + weight;
                    pq.offer(new int[]{dist[v], v});
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Distance from " + (char)(src + 'A') + " to " + (char)(i + 'A') + " is " + dist[i]);
        }

    }

    public static void main(String[] args) {
        int n = 4;
        List<List<Edge>> graph = new ArrayList<>();
        IntStream.range(0,n).forEach(x -> graph.add(new ArrayList<>()));

        graph.get(0).add(new Edge(1,4));
        graph.get(0).add(new Edge(2,3));
        graph.get(1).add(new Edge(3,2));
        graph.get(2).add(new Edge(3,5));

        dijkstra(graph, 0);

    }
}
