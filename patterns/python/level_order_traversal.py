from collections import deque

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class LevelOrderTraversal:
    def level_order(self, root):
        if root is None:
            return

        queue = deque([root])

        while queue:
            node = queue.popleft()
            print(node.val, end=" ")  # Process the node by printing its value
            
            # Add the left and right children to the queue, if they exist
            if node.left:
                queue.append(node.left)
            if node.right:
                queue.append(node.right)