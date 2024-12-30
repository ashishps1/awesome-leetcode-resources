package patterns.java;

class ListNode {
    int val;
    ListNode next;
}

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null; // Previous node, initially null
        ListNode curr = head; // Current node starts from the head
        while (curr != null) {
            ListNode next = curr.next; // Store next node
            curr.next = prev; // Reverse the current node's pointer
            prev = curr; // Move prev to current
            curr = next; // Move curr to next
        }
        return prev; // New head of the reversed list
    }    
}
