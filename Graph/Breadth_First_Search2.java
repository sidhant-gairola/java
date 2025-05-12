//when you have a disconnected graphlike   1->2->3  &&  4->5
//so as you can see we have two different component graphs which are disconnected so to make them connected we need to follow the previous plus some new approach
// This approach is more practical than the other one because it cover both the connected as well as disconnected graphs

// time complexity : O(V + E)

import java.util.*;

public class Breadth_First_Search2 {
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

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));

    }

    public static void bfs(ArrayList<Edge> graph[], int V, boolean[] vis, int start) {
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        while (!q.isEmpty()) {
            int cur = q.remove();
            if (vis[cur] == false) {
                System.out.print(cur + " ");
                vis[cur] = true;
                for (Edge e : graph[cur]) {
                    q.add(e.dest);
                }
            }
        }
    }

    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        boolean[] vis = new boolean[V];
        for (int i = 0; i < vis.length; i++) {
            if (vis[i] == false) {
                bfs(graph, V, vis, i);
            }
        }

        System.out.println();
    }
}