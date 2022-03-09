// Check if a binary search tree is valid or not

package Tree;

import Tree.utility.CreateBinarySearchTree;
import Tree.utility.TreeNode;

import java.util.Stack;

public class CheckValidBinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = CreateBinarySearchTree.createBinarySearchTree();
        System.out.println("Is Valid BST: " + isValidBSTRecursive(root, null, null));
        System.out.println("Is Valid BST: " + isValidBSTIterative(root));
    }

    // Recursive approach
    static boolean isValidBSTRecursive(TreeNode root, Integer low, Integer high) {
        if (root == null)
            return true;

        if ((low != null && root.val <= low) || (high != null && root.val >= high))
            return false;

        return isValidBSTRecursive(root.left, low, root.val) && isValidBSTRecursive(root.right, root.val, high);
    }

    // Iterative approach
    static boolean isValidBSTIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();

            if (prev != null && prev.val >= root.val)
                return false;

            prev = root;
            root = root.right;
        }
        return true;
    }
}
