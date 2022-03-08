// To invert (mirror) a binary tree

package Tree;

import Tree.utility.CreateBinaryTree;
import Tree.utility.TreeNode;

public class InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode root = CreateBinaryTree.createBinaryTree();

        root = invertBinaryTree(root);
    }

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
}
