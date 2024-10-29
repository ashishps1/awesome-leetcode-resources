using System;
using System.Collections.Generic;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
        next = null;
    }
}

public class FastAndSlowPointers {
    // LeetCode 141 - Linked List Cycle (HashSet Approach)
    public bool HasCycleHashSetApproach(ListNode head) {
        HashSet<ListNode> visited = new HashSet<ListNode>();
        ListNode current = head;
        while (current != null) {
            if (visited.Contains(current)) {
                return true; // Cycle detected
            }
            visited.Add(current);
            current = current.next;
        }
        return false; // No cycle
    }

    // LeetCode 141 - Linked List Cycle (Fast and Slow Pointer Approach)
    public bool HasCycleFastAndSlowPointersApproach(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    // LeetCode 876 - Middle of the Linked List (Counting Approach)
    public ListNode MiddleNodeCountingApproach(ListNode head) {
        int count = 0;
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        current = head;
        for (int i = 0; i < count / 2; i++) {
            current = current.next;
        }
        return current;
    }

    // LeetCode 876 - Middle of the Linked List (Fast and Slow Pointer Approach)
    public ListNode MiddleNodeFastAndSlowPointerApproach(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // LeetCode 202 - Happy Number (HashSet Approach)
    private int GetSumOfSquares(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    public bool IsHappyHashSetApproach(int n) {
        HashSet<int> seen = new HashSet<int>();
        while (n != 1 && !seen.Contains(n)) {
            seen.Add(n);
            n = GetSumOfSquares(n);
        }
        return n == 1;
    }

    // LeetCode 202 - Happy Number (Fast and Slow Pointer Approach)
    public bool IsHappyFastAndSlowPointersApproach(int n) {
        int slow = n;
        int fast = GetSumOfSquares(n);
        while (fast != 1 && slow != fast) {
            slow = GetSumOfSquares(slow);
            fast = GetSumOfSquares(GetSumOfSquares(fast));
        }
        return fast == 1;
    }
}