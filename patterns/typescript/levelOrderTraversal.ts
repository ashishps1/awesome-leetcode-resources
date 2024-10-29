// Definition for a binary tree node.
class BinaryTreeNode {
    val: number;
    left: TreeNode | null;
    right: TreeNode | null;

    constructor(val: number) {
        this.val = val;
        this.left = this.right = null;
    }
}

class BinaryTreeLevelOrderTraversal {
    levelOrder(root: BinaryTreeNode | null): void {
        if (root === null) return;

        const queue: BinaryTreeNode[] = [root];

        while (queue.length > 0) {
            const node = queue.shift()!;
            console.log(node.val); // Process the node by printing its value
            
            // Add the left and right children to the queue, if they exist
            if (node.left !== null) queue.push(node.left);
            if (node.right !== null) queue.push(node.right);
        }
    }
}