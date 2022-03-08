// To print post order traversal of a binary tree

package Tree;

import Tree.utility.CreateBinaryTree;
import Tree.utility.TreeNode;
import java.util.Stack;

public class PostOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = CreateBinaryTree.CreateBinaryTree();

        System.out.print("Post Order Traversal (Recursive):");
        // Call to recursive method
        postOrderRecursive(root);
        System.out.println();

        System.out.print("Post Order Traversal (Iterative):");
        // Call to iterative method
        postOrderIterative(root);
        System.out.println();
    }

    // Recursive method
    static void postOrderRecursive(TreeNode root) {
        if (root == null)
            return;

        postOrderRecursive(root.left);
        postOrderRecursive(root.right);
        System.out.print(" " + root.val);
    }

    // Iterative method
    static void postOrderIterative(TreeNode root) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);

        while (!stack1.isEmpty()) {
            TreeNode temp = stack1.pop();
            stack2.push(temp);

            if (temp.left != null) stack1.push(temp.left);
            if (temp.right != null) stack1.push(temp.right);
        }

        while (!stack2.isEmpty()) {
            System.out.print(" " + stack2.pop().val);
        }
    }
}
