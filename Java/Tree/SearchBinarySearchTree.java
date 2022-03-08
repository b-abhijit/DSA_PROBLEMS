// To search if a node with a given value exists in a binary search tree
// and if it exists return the subtree with that node else return null

package Tree;

import Tree.utility.CreateBinarySearchTree;
import Tree.utility.TreeNode;

public class SearchBinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = CreateBinarySearchTree.createBinarySearchTree();
        int target = 5;

        root = searchBST(root, target);

        if (root == null)
            System.out.printf(target + " does not exist in the tree");
        else
            System.out.printf(target + " exists in the tree");

    }

    static TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return null;

        if (root.val == val)
            return root;

        TreeNode temp = null;

        if (root.val < val) {
            temp = searchBST(root.right, val);
        } else {
            temp = searchBST(root.left, val);
        }

        return temp;
    }
}
