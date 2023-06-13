// Program to get minimum cost of a spanning tree (Prim's Algorithm implementation)

package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumSpanningTreeCost {
    public static void main(String[] args) {
        int V = 7, E = 7;
        int[][] edges = {
                {0, 1, 3},
                {1, 3, 3},
                {1, 5, 10},
                {2, 4, 6},
                {2, 6, 9},
                {3, 6, 8},
                {4, 5, 6}
        };
//        int V = 3, E = 3;
//        int[][] edges = {
//                {0, 1, 5},
//                {1, 2, 3},
//                {0, 2, 1}
//        };

        System.out.println("Minimum Cost: " + new MinimumSpanningTreeCost().getMinimumSpanningTreeCost(V, E, edges));
    }

    int getMinimumSpanningTreeCost(int V, int E, int[][] edges) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((arr1, arr2) -> Integer.compare(arr1[2], arr2[2]));
        boolean[] visited = new boolean[V];
        List<List<int[]>> matrix = new ArrayList<>();
        int min_cost = 0;

        for (int i = 0; i < V; ++i) {
            matrix.add(new ArrayList<>());
        }

        for (int[] edge: edges) {
            matrix.get(edge[0]).add(new int[] {edge[0], edge[1], edge[2]});
            matrix.get(edge[1]).add(new int[] {edge[1], edge[0], edge[2]});
        }

        pq.offer(new int[]{-1, 0, 0});

        while (!pq.isEmpty()) {
            int[] edge = pq.poll();

            if (!visited[edge[1]]) {
                if (edge[0] >= 0) min_cost += edge[2];

                for (int[] adj_edge: matrix.get(edge[1])) {
                    if (!visited[adj_edge[1]])
                        pq.offer(adj_edge);
                }
                visited[edge[1]] = true;
            }
        }

        return min_cost;
    }

}
