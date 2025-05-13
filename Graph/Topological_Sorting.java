import java.util.*;

public class Topological_Sorting {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[], int V) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    public static void topSort(ArrayList<Edge> graph[], boolean[] vis, int cur, Stack<Integer> stack) {
        vis[cur] = true;
        for (Edge e : graph[cur]) { // For every edge from current node
            if (!vis[e.dest]) { // if destination is not visited
                topSort(graph, vis, e.dest, stack);
            }
        }
        stack.push(cur);// push current vertex to stack only after all of its neighboring vertices
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph, V);
        boolean[] vis = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                topSort(graph, vis, i, stack);
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
