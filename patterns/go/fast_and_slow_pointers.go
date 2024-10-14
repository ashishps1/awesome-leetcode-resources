package main

import "fmt"

type ListNode struct {
    Val  int
    Next *ListNode
}

// LeetCode 141 - Linked List Cycle (HashSet Approach)
func hasCycleHashSetApproach(head *ListNode) bool {
    visited := map[*ListNode]bool{}
    current := head
    for current != nil {
        if visited[current] {
            return true
        }
        visited[current] = true
        current = current.Next
    }
    return false
}

// LeetCode 141 - Linked List Cycle (Fast and Slow Pointer Approach)
func hasCycleFastAndSlowPointersApproach(head *ListNode) bool {
    if head == nil || head.Next == nil {
        return false
    }
    slow, fast := head, head
    for fast != nil && fast.Next != nil {
        slow = slow.Next
        fast = fast.Next.Next
        if slow == fast {
            return true
        }
    }
    return false
}

// LeetCode 876 - Middle of the Linked List (Counting Approach)
func middleNodeCountingApproach(head *ListNode) *ListNode {
    count := 0
    current := head
    for current != nil {
        count++
        current = current.Next
    }
    current = head
    for i := 0; i < count/2; i++ {
        current = current.Next
    }
    return current
}

// LeetCode 876 - Middle of the Linked List (Fast and Slow Pointer Approach)
func middleNodeFastAndSlowPointerApproach(head *ListNode) *ListNode {
    slow, fast := head, head
    for fast != nil && fast.Next != nil {
        slow = slow.Next
        fast = fast.Next.Next
    }
    return slow
}

// LeetCode 202 - Happy Number (HashSet Approach)
func getSumOfSquares(n int) int {
    sum := 0
    for n > 0 {
        digit := n % 10
        sum += digit * digit
        n /= 10
    }
    return sum
}

func isHappyHashSetApproach(n int) bool {
    seen := map[int]bool{}
    for n != 1 && !seen[n] {
        seen[n] = true
        n = getSumOfSquares(n)
    }
    return n == 1
}

// LeetCode 202 - Happy Number (Fast and Slow Pointer Approach)
func isHappyFastAndSlowPointersApproach(n int) bool {
    slow := n
    fast := getSumOfSquares(n)
    for fast != 1 && slow != fast {
        slow = getSumOfSquares(slow)
        fast = getSumOfSquares(getSumOfSquares(fast))
    }
    return fast == 1
}

func main() {
    // You can test the implementations here
}