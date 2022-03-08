package Tree.utility;

public class CreateBinarySearchTree {

    //             4
    //          /    \
    //         2      6
    //       /   \   /  \
    //      1     3 5    7

    public static TreeNode createBinarySearchTree() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        return root;
    }
}
