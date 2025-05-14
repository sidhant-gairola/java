// This algo is better than  Dijkstra's algo because of its ability to work on negative weights which dijkstra cant
// its time complexity is higher than dijkstras O(E.V) 

import java.util.*;

public class Bellman_Ford_Algo_Shortest_Path_Algo {
    public static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[], int V) {
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));
    }

    public static void bellmanFord(ArrayList<Edge> graph[], int src, int V) {
        int[] dist = new int[V];
        for (int i = 0; i < V; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        for (int k = 0; k < V - 1; k++) {
            for (int i = 0; i < V; i++) {
                for (Edge e : graph[i]) {
                    int u = e.src;
                    int v = e.dest;
                    if (dist[u] != Integer.MAX_VALUE && dist[v] > dist[u] + e.wt) {
                        dist[v] = dist[u] + e.wt;
                    }
                }
            }
        }
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }

        // // for negative cycle
        // for (int k = 0; k < V - 1; k++) {
        // for (int i = 0; i < V; i++) {
        // for (Edge e : graph[i]) {
        // int u = e.src;
        // int v = e.dest;
        // if (dist[u] != Integer.MAX_VALUE && dist[v] > dist[u] + e.wt) {
        // System.out.println("neg cycle detected");
        // }
        // }
        // }
        // }
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph, V);
        bellmanFord(graph, 0, V);
    }
}
