class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class FastAndSlowPointers:
    # LeetCode 141 - Linked List Cycle (HashSet Approach)
    def hasCycleHashSetApproach(self, head):
        visited = set()
        current = head
        while current:
            if current in visited:
                return True
            visited.add(current)
            current = current.next
        return False

    # LeetCode 141 - Linked List Cycle (Fast and Slow Pointer Approach)
    def hasCycleFastAndSlowPointersApproach(self, head):
        if not head or not head.next:
            return False
        slow, fast = head, head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            if slow == fast:
                return True
        return False

    # LeetCode 876 - Middle of the Linked List (Counting Approach)
    def middleNodeCountingApproach(self, head):
        count = 0
        current = head
        while current:
            count += 1
            current = current.next
        current = head
        for _ in range(count // 2):
            current = current.next
        return current

    # LeetCode 876 - Middle of the Linked List (Fast and Slow Pointer Approach)
    def middleNodeFastAndSlowPointerApproach(self, head):
        slow, fast = head, head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        return slow

    # LeetCode 202 - Happy Number (HashSet Approach)
    def getSumOfSquares(self, n):
        return sum(int(digit)**2 for digit in str(n))

    def isHappyHashSetApproach(self, n):
        seen = set()
        while n != 1 and n not in seen:
            seen.add(n)
            n = self.getSumOfSquares(n)
        return n == 1

    # LeetCode 202 - Happy Number (Fast and Slow Pointer Approach)
    def isHappyFastAndSlowPointersApproach(self, n):
        slow = n
        fast = self.getSumOfSquares(n)
        while fast != 1 and slow != fast:
            slow = self.getSumOfSquares(slow)
            fast = self.getSumOfSquares(self.getSumOfSquares(fast))
        return fast == 1