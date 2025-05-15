import java.util.ArrayList;
import java.util.Stack;

public class Kosaraju_algo_SCC {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));
    }

    // topological sort
    public static void topSort(ArrayList<Edge> graph[], int cur, boolean[] vis, Stack<Integer> s) {
        vis[cur] = true;
        for (Edge e : graph[cur]) {
            if (!vis[e.dest]) {
                topSort(graph, e.dest, vis, s);
            }
        }
        s.push(cur);
    }

    public static void dfs(ArrayList<Edge> graph[], int cur, boolean[] vis) {
        vis[cur] = true;
        System.out.print(cur + " ");
        for (Edge e : graph[cur]) {
            if (!vis[e.dest]) {
                dfs(graph, e.dest, vis);
            }
        }

    }

    public static void kosarajuAlgo(ArrayList<Edge> graph[], int V) { // O(E + V)
        // step 1 : fill the stack - topological sort
        Stack<Integer> s = new Stack<>();
        boolean vis[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                topSort(graph, i, vis, s);
            }
        }

        // step 2: transpose the graph - reverse the edge direction
        ArrayList<Edge> transpose[] = new ArrayList[V];
        for (int i = 0; i < graph.length; i++) {
            transpose[i] = new ArrayList<Edge>();
            vis[i] = false;
        }
        for (int i = 0; i < V; i++) {
            for (Edge e : graph[i]) {
                transpose[e.dest].add(new Edge(e.dest, e.src));
            }
        }

        // step 3: perform dfs
        while (!s.isEmpty()) {
            int cur = s.pop();
            if (!vis[cur]) {
                dfs(transpose, cur, vis);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        kosarajuAlgo(graph, V);
    }
}
