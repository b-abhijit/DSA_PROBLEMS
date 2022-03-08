// To find the maximum depth of a binary tree

package Tree;

import Tree.utility.CreateBinaryTree;
import Tree.utility.TreeNode;

public class MaximumDepthBinaryTree {
    public static void main(String[] args) {
        TreeNode root = CreateBinaryTree.createBinaryTree();

        System.out.printf("Maximum depth: " + maxDepth(root));
    }

    static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
