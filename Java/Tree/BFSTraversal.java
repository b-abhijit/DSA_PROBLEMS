// To print level order traversal (breadth first search) of a binary tree

package Tree;

import Tree.utility.CreateBinaryTree;
import Tree.utility.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSTraversal {
    public static void main(String[] args) {
        TreeNode root = CreateBinaryTree.CreateBinaryTree();
        List<List<Integer>> result = new ArrayList<>();

        result = bfsTraversal(root, result);

        System.out.println("Level Order Traversal");
        for (List<Integer> level: result) {
            System.out.println(level);
        }
    }

    static List<List<Integer>> bfsTraversal(TreeNode root, List<List<Integer>> result) {
        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int queueSize = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < queueSize; ++i) {
                TreeNode temp = queue.poll();
                level.add(temp.val);

                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
            }
            result.add(level);
        }

        return result;
    }
}
