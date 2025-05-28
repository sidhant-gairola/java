import java.util.*;

public class Bridge_Tarjans_Algo {
    static class Edge {
        int src;
        int dest;

        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[], int V) {
        for (int i = 0; i < V; i++) {
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
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
    }

    public static void dfs(ArrayList<Edge> graph[], int cur, boolean[] vis, int[] dt, int[] low, int time, int par) {
        vis[cur] = true;
        dt[cur] = low[cur] = ++time;
        for (Edge e : graph[cur]) {
            if (e.dest == par)
                continue;
            else if (!vis[e.dest]) {
                dfs(graph, e.dest, vis, dt, low, time, cur);
                low[cur] = Math.min(low[cur], low[e.dest]);
                if (dt[cur] < low[e.dest]) {
                    System.out.println("bridge is : " + cur + "->" + e.dest);
                }
            } else {
                low[cur] = Math.min(low[cur], dt[e.dest]);
            }
        }
    }

    public static void getBridges(ArrayList<Edge> graph[], int V) {
        int[] dt = new int[V];
        int[] low = new int[V];
        int time = 0;
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(graph, i, vis, dt, low, time, -1); // here last element is the parent to that node
            }
        }
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph, V);
        getBridges(graph, V);
    }
}
