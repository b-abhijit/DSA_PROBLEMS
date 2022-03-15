// To print the top view of a binary tree

package Tree;

import Tree.utility.CreateBinaryTree;
import Tree.utility.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class TopViewBinaryTree {
    public static void main(String[] args) {
        TreeNode root = CreateBinaryTree.createBinaryTree();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        Queue<Pair> pq = new LinkedList<>();

        topViewDFS(root, treeMap, 0);
        System.out.print("Top view of binary tree (DFS):");
        for (int key: treeMap.keySet()) {
            System.out.print(" " + treeMap.get(key));
        }
        System.out.println();

        topViewBFS(root, pq, treeMap);
        System.out.print("Top view of binary tree (BFS):");
        for (int key: treeMap.keySet()) {
            System.out.print(" " + treeMap.get(key));
        }
        System.out.println();
    }

    // DFS Approach
    static void topViewDFS(TreeNode root, TreeMap<Integer, Integer> treeMap, int idx) {
        if (root == null)
            return;

        if (!treeMap.containsKey(idx))
            treeMap.put(idx, root.val);

        topViewDFS(root.left, treeMap, idx - 1);
        topViewDFS(root.right, treeMap, idx + 1);
    }

    // BFS Approach
    static void topViewBFS(TreeNode root, Queue<Pair> pq, TreeMap<Integer, Integer> treeMap) {
        pq.offer(new Pair(0, root));

        while (!pq.isEmpty()) {
            int size = pq.size();

            for (int i = 0; i < size; ++i) {
                Pair pair = pq.poll();
                int idx = pair.num1;
                TreeNode node = pair.node;

                if (!treeMap.containsKey(idx))
                    treeMap.put(idx, node.val);

                if (node.left != null)
                    pq.offer(new Pair(idx - 1, node.left));

                if (node.right != null)
                    pq.offer(new Pair(idx + 1, node.right));
            }
        }
    }

    // Inner class to implement comparable interface
    static class Pair implements Comparable<Pair>{
        int num1;
        TreeNode node;

        Pair(int num1, TreeNode node) {
            this.num1 = num1;
            this.node = node;
        }

        @Override
        public int compareTo(Pair pair) {
            return this.num1 - pair.num1;
        }

    }
}
