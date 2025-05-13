import java.util.ArrayList;

public class Cycle_Detection_Undirected {
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
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 4));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 4));

        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 2));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 4));
    }

    public static boolean isCyclicUndirected(ArrayList<Edge> graph[], int cur, boolean[] vis, int par) {
        vis[cur] = true;
        for (Edge e : graph[cur]) {
            if (vis[e.dest] && par != e.dest) {
                return true;
            } else if (!vis[e.dest]) {
                if (isCyclicUndirected(graph, e.dest, vis, cur)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph, V);
        boolean[] vis = new boolean[V];
        System.out.println(isCyclicUndirected(graph, 0, vis, -1)) ;

    }
}
