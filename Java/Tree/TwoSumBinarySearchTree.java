// Check if a pair with the given sum exists

package Tree;

import Tree.utility.CreateBinarySearchTree;
import Tree.utility.TreeNode;

import java.util.HashSet;

public class TwoSumBinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = CreateBinarySearchTree.createBinarySearchTree();
        int target = 7;

        System.out.println("Pair exists: " + findTargetSum(root, target, new HashSet<Integer>()));
    }

    static boolean findTargetSum(TreeNode root, int target, HashSet<Integer> numSet) {
        if (root == null)
            return false;

        if (numSet.contains(target - root.val))
            return true;
        else
            numSet.add(root.val);

        return findTargetSum(root.left, target, numSet) || findTargetSum(root.right, target, numSet);
    }
}
