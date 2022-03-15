// To print the vertical order traversal of a binary tree

package Tree;

import Tree.utility.CreateBinaryTree;
import Tree.utility.TreeNode;

import java.util.*;

public class VerticalOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = CreateBinaryTree.createBinaryTree();
        verticalTraversal(root);
    }

    static void verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> treeMap = new TreeMap<>();
        TreeMap<Integer, LinkedHashMap<Integer, PriorityQueue<Integer>>> treeMap2 = new TreeMap<>();
        List<List<Integer>> result = new ArrayList<>();

        verticalOrderTraversalDFS(root, treeMap, 0, 0);
        for (TreeMap<Integer, PriorityQueue<Integer>> map: treeMap.values()) {
            List<Integer> list = new ArrayList<>();
            for (PriorityQueue<Integer> pq: map.values()) {
                while (!pq.isEmpty()) {
                    list.add(pq.poll());
                }
            }
            result.add(list);
        }
        System.out.println("Vertical order traversal (DFS): " + result);

        result.clear();
         verticalOrderTraversalBFS(root, treeMap2, 0, 0);
         for (LinkedHashMap<Integer, PriorityQueue<Integer>> map: treeMap2.values()) {
             List<Integer> list = new ArrayList<>();
             for (PriorityQueue<Integer> pq: map.values()) {
                 while (!pq.isEmpty()) {
                     list.add(pq.poll());
                 }
             }
             result.add(list);
         }
        System.out.println("Vertical order traversal (BFS): " + result);

    }

    // DFS Approach
    static void verticalOrderTraversalDFS(TreeNode root, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> treeMap, int row, int col) {
        if (root == null)
            return;

        if (!treeMap.containsKey(col)) {
            TreeMap<Integer, PriorityQueue<Integer>> map = new TreeMap<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            pq.offer(root.val);
            map.put(row, pq);
            treeMap.put(col, map);
        } else {
            TreeMap<Integer, PriorityQueue<Integer>> map = treeMap.get(col);
            if (!map.containsKey(row)) {
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                pq.offer(root.val);
                map.put(row, pq);
            } else {
                PriorityQueue<Integer> pq = map.get(row);
                pq.offer(root.val);
                map.put(row, pq);
            }
            treeMap.put(col, map);
        }

        verticalOrderTraversalDFS(root.left, treeMap, row + 1, col - 1);
        verticalOrderTraversalDFS(root.right, treeMap, row + 1, col + 1);
    }

    // BFS Approach
    static void verticalOrderTraversalBFS(TreeNode root, TreeMap<Integer, LinkedHashMap<Integer, PriorityQueue<Integer>>> treeMap, int row, int col) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0, root));

        while (!queue.isEmpty()) {
            int size = queue.size();
            row += 1;

            for (int i = 0; i < size; ++i) {
                Pair pair = queue.poll();
                col = pair.num;
                root = pair.node;

                if (!treeMap.containsKey(col)) {
                    LinkedHashMap<Integer, PriorityQueue<Integer>> map = new LinkedHashMap<>();
                    PriorityQueue<Integer> pq = new PriorityQueue<>();
                    pq.offer(root.val);
                    map.put(row, pq);
                    treeMap.put(col, map);
                } else {
                    LinkedHashMap<Integer, PriorityQueue<Integer>> map = treeMap.get(col);
                    if (!map.containsKey(row)) {
                        PriorityQueue<Integer> pq = new PriorityQueue<>();
                        pq.offer(root.val);
                        map.put(row, pq);
                    } else {
                        PriorityQueue<Integer> pq = map.get(row);
                        pq.offer(root.val);
                        map.put(row, pq);
                    }
                    treeMap.put(col, map);
                }

                if (root.left != null) queue.offer(new Pair(col - 1, root.left));
                if (root.right != null) queue.offer(new Pair(col + 1, root.right));
            }
        }
    }

    static class Pair implements Comparable<Pair> {
        int num;
        TreeNode node;

        Pair(int num, TreeNode node) {
            this.num = num;
            this.node = node;
        }

        @Override
        public int compareTo(Pair pair) {
            return this.num - pair.num;
        }
    }
}
