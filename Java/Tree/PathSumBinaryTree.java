// To find if the sum of all nodes in a path from root to leaf equals the given target sum

package Tree;

import Tree.utility.CreateBinaryTree;
import Tree.utility.TreeNode;

public class PathSumBinaryTree {
    public static void main(String[] args) {
        TreeNode root = CreateBinaryTree.createBinaryTree();
        int targetSum = 10;
        int currentSum = Integer.MIN_VALUE;

        System.out.printf("Exist target sum: " + checkTargetSum(root, targetSum, currentSum));
    }

    static boolean checkTargetSum(TreeNode root, int targetSum, int currentSum) {
        if (currentSum == Integer.MIN_VALUE)
            currentSum = root.val;
        else
            currentSum += root.val;

        if (targetSum == currentSum && root.left == null && root.right == null)
            return true;


        if (root.left != null && checkTargetSum(root.left, targetSum, currentSum) == true)
            return true;
        if (root.right != null && checkTargetSum(root.right, targetSum, currentSum) == true)
            return true;

        return false;
    }
}
