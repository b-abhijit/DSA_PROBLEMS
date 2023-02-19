// To find if the sum of all nodes in a path from root to leaf equals the given target sum

package Tree;

import Tree.utility.CreateBinaryTree;
import Tree.utility.TreeNode;

public class PathSumBinaryTree {
    public static void main(String[] args) {
        TreeNode root = CreateBinaryTree.createBinaryTree();
        int targetSum = 10;

        System.out.printf("Exist target sum: " + checkTargetSum(root, targetSum, 0));
    }

    static boolean checkTargetSum(TreeNode root, int targetSum, int currentSum) {
        if (root == null)
            return false;

        if (root.left == null && root.right == null && currentSum + root.val == targetSum)
            return true;

        if (checkTargetSum(root.left, targetSum, currentSum + root.val) || checkTargetSum(root.right, targetSum, currentSum + root.val))
            return true;

        return false;
    }
}
