// To check if a binary tree is symmetric or not

package Tree;

import Tree.utility.CreateBinaryTree;
import Tree.utility.TreeNode;

public class CheckSymmetryBinaryTree {
    public static void main(String[] args) {
        TreeNode root = CreateBinaryTree.createBinaryTree();

        System.out.printf("Is Symmetric: " + isSymmetric(root.left, root.right));
    }

    static boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null || right == null)
            return left == right;

        if (left.val != right.val)
            return false;

        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
