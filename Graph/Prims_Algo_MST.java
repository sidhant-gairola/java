import java.util.*;

public class Prims_Algo_MST {

    static class Edge {
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
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 0, 30));
        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }

    static class Pair implements Comparable<Pair> {
        int node;
        int cost;

        public Pair(int n, int c) {
            this.cost = c;
            this.node = n;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost; // ascending order
        }
    }

    public static void primsAlgo(ArrayList<Edge> graph[], int V) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(); // non-MST set
        boolean[] vis = new boolean[V]; // MST set
        pq.add(new Pair(0, 0));
        int totalCost = 0;

        while (!pq.isEmpty()) {
            Pair cur = pq.remove();
            if (!vis[cur.node]) {
                vis[cur.node] = true;
                totalCost += cur.cost;
                for (Edge e : graph[cur.node]) {
                    if (!vis[e.dest]) {
                        pq.add(new Pair(e.dest, e.wt));
                    }
                }
            }
        }
        System.out.println("Min cost of MST : " + totalCost);
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph, V);
        primsAlgo(graph, V);
    }
}
