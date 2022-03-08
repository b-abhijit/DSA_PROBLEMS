// To insert a node into a binary search tree

package Tree;

import Tree.utility.CreateBinarySearchTree;
import Tree.utility.TreeNode;

public class InsertBinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = CreateBinarySearchTree.createBinarySearchTree();
        int value = 9;

        root = insertBST(root, value);
    }

    static TreeNode insertBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (root.val < val) {
            root.right = insertBST(root.right, val);
        } else {
            root.left = insertBST(root.left, val);
        }

        return root;
    }
}
