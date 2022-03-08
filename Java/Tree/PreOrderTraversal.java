// To print pre order traversal of a binary tree

package Tree;

import Tree.utility.CreateBinaryTree;
import Tree.utility.TreeNode;
import java.util.Stack;

public class PreOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = CreateBinaryTree.CreateBinaryTree();

        System.out.print("Pre Order Traversal (Recursive):");
        // Call to recursive method
        preOrderRecursive(root);
        System.out.println();

        System.out.print("Pre Order Traversal (Iterative):");
        // Call to iterative method
        preOrderIterative(root);
        System.out.println();

    }

    // Recursive method
    static void preOrderRecursive(TreeNode root) {
        if (root == null)
            return;

        System.out.print(" " + root.val);
        preOrderRecursive(root.left);
        preOrderRecursive(root.right);
    }

    // Iterative method
    static void preOrderIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            System.out.print(" " + temp.val);

            if (temp.right != null) stack.push(temp.right);
            if (temp.left != null) stack.push(temp.left);
        }
    }
}


