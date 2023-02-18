// To invert (mirror) a binary tree

package Tree;

import Tree.utility.CreateBinaryTree;
import Tree.utility.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode root = CreateBinaryTree.createBinaryTree();

        System.out.println("Before inversion");
        InOrderTraversal.inOrderRecursive(root);

//        root = invertBinaryTree(root);
        root = invertBinaryTreeIterative(root);

        System.out.println("\nAfter inversion");
        InOrderTraversal.inOrderRecursive(root);
    }

    // DFS Approach
    static TreeNode invertBinaryTree(TreeNode root) {
        if (root == null)
            return null;

        invertBinaryTree(root.left);
        invertBinaryTree(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }

    // BFS Approach
    static TreeNode invertBinaryTreeIterative(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();

                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return root;
    }
}
