package patterns.java;

import java.util.HashSet;

public class FastAndSlowPointers {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

/*
 * ********** LeetCode 141 - Linked List Cycle (https://leetcode.com/problems/linked-list-cycle/) **********
*/    
    
    public boolean hasCycleHashSetAppraoch(ListNode head) {
        HashSet<ListNode> visited = new HashSet<>();
        ListNode current = head;
        while (current != null) {
            if (visited.contains(current)) {
                return true; // Cycle detected
            }
            visited.add(current);
            current = current.next;
        }
        return false; // No cycle
    }

    public boolean hasCycleFastAndSlowPointersAppraoch(ListNode head) {
        if (head == null || head.next == null) {
            return false; // No cycle if the list is empty or has only one node
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;        // Move slow pointer by 1 step
            fast = fast.next.next;   // Move fast pointer by 2 steps

            if (slow == fast) {
                return true; // Cycle detected
            }
        }

        return false; // No cycle
    }

/*
 * ********** LeetCode 876 - Middle of the Linked List (https://leetcode.com/problems/middle-of-the-linked-list/description/) **********
*/

    public ListNode middleNodeCountingApproach(ListNode head) {
        int count = 0;
        ListNode current = head;

        // First pass to count the number of nodes
        while (current != null) {
            count++;
            current = current.next;
        }

        // Second pass to find the middle node
        current = head;
        for (int i = 0; i < count / 2; i++) {
            current = current.next;
        }

        return current; // This will be the middle node
    }

    public ListNode middleNodeFastAndSlowPointerApproach(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Move slow by 1 and fast by 2 steps
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow; // Slow will be at the middle node
    }

/*
 * ********** LeetCode 202 - Happy Number (https://leetcode.com/problems/happy-number/description/) **********
*/

    private int getSumOfSquares(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    public boolean isHappyHashSetApproach(int n) {
        HashSet<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getSumOfSquares(n);
        }
        return n == 1;
    }

    public boolean isHappyFastAndSlowPointersApproach(int n) {
        int slow = n;
        int fast = getSumOfSquares(n);

        while (fast != 1 && slow != fast) {
            slow = getSumOfSquares(slow);        // Move slow by 1 step
            fast = getSumOfSquares(getSumOfSquares(fast)); // Move fast by 2 steps
        }

        return fast == 1;
    }
}