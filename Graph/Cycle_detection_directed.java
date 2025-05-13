import java.util.*;

public class Cycle_detection_directed {
    static class Edge {
        int src;
        int dest;

        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[], int V) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 0));
    }

    public static boolean isCyclicDirected(ArrayList<Edge> graph[], int cur, boolean[] vis, boolean[] rec) {
        vis[cur] = true;
        rec[cur] = true;
        for (Edge e : graph[cur]) {
            if (rec[e.dest]) { // cycle
                return true;
            } else if (!vis[e.dest]) { // not visited this node
                if (isCyclicDirected(graph, e.dest, vis, rec)) {
                    return true; // cycle found
                }
            }
        }
        rec[cur] = false;
        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph, V);
        boolean[] vis = new boolean[V];
        boolean[] rec = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                boolean res = isCyclicDirected(graph, i, vis, rec);
                if (res) {
                    System.out.println("Graph contains cycle");
                    break;
                }
            }
        }
    }
}
