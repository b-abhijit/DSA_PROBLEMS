// To check if a binary tree is symmetric or not

package Tree;

import Tree.utility.CreateBinaryTree;
import Tree.utility.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CheckSymmetryBinaryTree {
    public static void main(String[] args) {
        TreeNode root = CreateBinaryTree.createBinaryTree();

//        System.out.println("Is Symmetric: " + isSymmetric(root.left, root.right));
        System.out.println("Is Symmetric: " + isSymmetricIterative(root.left));
    }

    // DFS Approach
    static boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null || right == null)
            return left == right;

        if (left.val != right.val)
            return false;

        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    // BFS Approach
    static boolean isSymmetricIterative(TreeNode root) {
        if (root.left == null || root.right == null)
            return root.left == root.right;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            int size = queue.size();

            if (size % 2 != 0)
                return false;

            for (int i = 0; i < size / 2; ++i) {
                TreeNode node1 = queue.poll();
                TreeNode node2 = queue.poll();

                if (node1.val != node2.val)
                    return false;

                if (node1.left != null && node2.right != null) {
                    queue.offer(node1.left);
                    queue.offer(node2.right);
                } else if ((node1.left == null && node2.right != null) || (node1.left != null && node2.right == null))
                    return false;

                if (node1.right != null && node2.left != null) {
                    queue.offer(node1.right);
                    queue.offer(node2.left);
                } else if ((node1.right == null && node2.left != null) || (node1.right != null && node2.left == null))
                    return false;
            }
        }

        return true;
    }
}
