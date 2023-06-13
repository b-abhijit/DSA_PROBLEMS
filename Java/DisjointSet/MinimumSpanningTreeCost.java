// Program to get minimum cost of a spanning tree (Kruskal's Algorithm implementation)

package DisjointSet;

import java.util.PriorityQueue;

public class MinimumSpanningTreeCost {
    static int[] parent, rank;

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
        PriorityQueue<int[]> pq = new PriorityQueue<>((arr1, arr2) -> Integer.compare(arr1[2], arr2[2]));
        int min_cost = 0;
        new DisjointSetUnionFind(V);

        for (int[] edge: edges) {
            pq.offer(edge);
        }

        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            int vertex1 = edge[0], vertex2 = edge[1];
            int parent1 = DisjointSetUnionFind.findParent(vertex1), parent2 = DisjointSetUnionFind.findParent(vertex2);
            if (parent1 != parent2) {
                min_cost += edge[2];
                DisjointSetUnionFind.union(parent1, parent2);
            }
        }

        return min_cost;
    }

     class DisjointSetUnionFind {
        DisjointSetUnionFind(int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; ++i) {
                parent[i] = i;
            }
        }

        static void union(int parent1, int parent2) {
            if (getRank(parent1) > getRank(parent2)) {
                parent[parent2] = parent1;
                rank[parent1] += rank[parent2] + 1;
            } else if (getRank(parent1) < getRank(parent2)) {
                parent[parent1] = parent2;
                rank[parent2] += rank[parent1] + 1;
            } else {
                if (parent1 > parent2) {
                    parent[parent1] = parent2;
                    rank[parent2] += rank[parent1] + 1;
                } else {
                    parent[parent2] = parent1;
                    rank[parent1] += rank[parent2] + 1;
                }
            }
        }

        static int findParent(int vertex) {
            if (parent[vertex] == vertex)
                return vertex;

            return findParent(parent[vertex]);
        }

        static int getRank(int vertex) {
            return rank[vertex];
        }
    }
}
