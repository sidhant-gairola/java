import java.util.*;

public class Articulation_Point_Using_Tarjans_Algo {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        // This will create a empty arraylist for each index in the graph[]
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));
    }

    // O(V+E)
    public static void dfs(ArrayList<Edge> graph[], int cur, int par, int[] dt, int[] low, boolean[] vis, int time,
            boolean[] ap) {
        vis[cur] = true;
        dt[cur] = low[cur] = ++time;
        int children = 0;
        for (Edge e : graph[cur]) {
            int neigh = e.dest;
            if (par == neigh)
                continue;
            else if (vis[neigh]) {
                low[cur] = Math.min(low[cur], dt[neigh]);
            } else {
                dfs(graph, neigh, cur, dt, low, vis, time, ap);
                low[cur] = Math.min(low[cur], low[neigh]);
                if (dt[cur] <= low[neigh] && par != -1) {
                    ap[cur] = true;
                }
                children++;
            }
        }
        if (par == -1 && children > 1) {
            ap[cur] = true;
        }
    }

    public static void getAP(ArrayList<Edge> graph[], int V) {
        int dt[] = new int[V];
        int low[] = new int[V];
        int time = 0;
        boolean vis[] = new boolean[V];
        boolean ap[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(graph, i, -1, dt, low, vis, time, ap);
            }
        }
        for (int i = 0; i < ap.length; i++) {
            if (ap[i]) {
                System.out.println("AP : " + i);
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        getAP(graph, V);
    }
}
