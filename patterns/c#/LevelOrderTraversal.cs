using System;
using System.Collections.Generic;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }
}

public class LevelOrderTraversal {
    public void LevelOrder(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new Queue<TreeNode>();
        queue.Enqueue(root);

        while (queue.Count > 0) {
            TreeNode node = queue.Dequeue();
            Console.Write(node.val + " "); // Process the node by printing its value
            
            // Add the left and right children to the queue, if they exist
            if (node.left != null) queue.Enqueue(node.left);
            if (node.right != null) queue.Enqueue(node.right);
        }
    }
}