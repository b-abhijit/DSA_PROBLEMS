package Tree;

import Tree.utility.CreateBinaryTree;
import Tree.utility.TreeNode;
import java.util.Stack;

public class InOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = CreateBinaryTree.CreateBinaryTree();

        System.out.print("In Order Traversal (Recursive):");
        // Call to recursive method
        inOrderRecursive(root);
        System.out.println();

        System.out.print("In Order Traversal (Iterative):");
        // Call to iterative method
        inOrderIterative(root);
        System.out.println();
    }

    // Recursive method
    static void inOrderRecursive(TreeNode root) {
        if (root == null)
            return;

        inOrderRecursive(root.left);
        System.out.print(" " + root.val);
        inOrderRecursive(root.right);
    }

    // Iterative method
    static void inOrderIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode temp = root.left;

        while (!stack.isEmpty() || temp != null) {
            if (temp == null) {
                temp = stack.pop();
                System.out.print(" " + temp.val);
                temp = temp.right;
            } else {
                stack.push(temp);
                temp = temp.left;
            }
        }
    }
}
