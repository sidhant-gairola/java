import java.util.*;

public class Dijkstra_Algo_Shortest_Path_Algo {

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

        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    public static class Pair implements Comparable<Pair> { // here comparable is implemented because in pair class it is
                                                           // not mentioned to prioritize the elements based on what
                                                           // features
        int node;
        int dist;

        public Pair(int n, int d) {
            this.node = n;
            this.dist = d;
        }

        @Override
        public int compareTo(Pair p2) { // here we compare the dist value of two
            return this.dist - p2.dist; // in ascendnig order | if dist is smaller then it will be smaller in the result
                                        // | if this retuwn negative value that means this value is smaller , if
                                        // positive this value is larger and if return 0 that means both the pair values
                                        // are equal
            // return p2.dist - this.dist //in desc order
        }
    }

    public static void dijkstras(ArrayList<Edge> graph[], int src, int V) { // O(E + E logV) : E log V because of
                                                                            // priority Queue
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] dist = new int[V];
        for (int i = 0; i < V; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        boolean[] vis = new boolean[V];

        pq.add(new Pair(0, 0));
        while (!pq.isEmpty()) {
            Pair cur = pq.remove(); // smallest
            if (!vis[cur.node]) {
                vis[cur.node] = true;
                for (Edge e : graph[cur.node]) {
                    int u = e.src;
                    int v = e.dest;
                    if (dist[v] > dist[u] + e.wt) { // Relaxation
                        dist[v] = dist[u] + e.wt;
                        pq.add(new Pair(v, dist[v])); // add to priority queue
                    }
                }
            }
        }
        for (int i = 0; i < V; i++) {
            System.out.print(dist[i] + " ");
        }
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph, V);
        dijkstras(graph, 0, V);
    }
}