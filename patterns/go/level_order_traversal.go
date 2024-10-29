package main

import "fmt"

// Definition for a binary tree node.
type TreeNode struct {
    Val   int
    Left  *TreeNode
    Right *TreeNode
}

func levelOrder(root *TreeNode) {
    if root == nil {
        return
    }

    queue := []*TreeNode{root}

    for len(queue) > 0 {
        node := queue[0]
        queue = queue[1:]
        fmt.Print(node.Val, " ") // Process the node by printing its value
        
        // Add the left and right children to the queue, if they exist
        if node.Left != nil {
            queue = append(queue, node.Left)
        }
        if node.Right != nil {
            queue = append(queue, node.Right)
    }
}

func main() {
    // Example usage
    root := &TreeNode{Val: 1}
    root.Left = &TreeNode{Val: 2}
    root.Right = &TreeNode{Val: 3}
    levelOrder(root) // Output: 1 2 3
}