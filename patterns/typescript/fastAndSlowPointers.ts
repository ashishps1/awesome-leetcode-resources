class ListNode {
    val: number;
    next: ListNode | null = null;
    constructor(x: number) {
        this.val = x;
    }
}

class FastAndSlowPointers {
    // LeetCode 141 - Linked List Cycle (HashSet Approach)
    hasCycleHashSetApproach(head: ListNode | null): boolean {
        const visited = new Set<ListNode>();
        let current = head;
        while (current) {
            if (visited.has(current)) {
                return true;
            }
            visited.add(current);
            current = current.next;
        }
        return false;
    }

    // LeetCode 141 - Linked List Cycle (Fast and Slow Pointer Approach)
    hasCycleFastAndSlowPointersApproach(head: ListNode | null): boolean {
        if (!head || !head.next) return false;
        let slow: ListNode | null = head;
        let fast: ListNode | null = head;
        while (fast && fast.next) {
            slow = slow!.next;
            fast = fast.next.next;
            if (slow === fast) return true;
        }
        return false;
    }

    // LeetCode 876 - Middle of the Linked List (Counting Approach)
    middleNodeCountingApproach(head: ListNode | null): ListNode | null {
        let count = 0;
        let current = head;
        while (current) {
            count++;
            current = current.next;
        }
        current = head;
        for (let i = 0; i < Math.floor(count / 2); i++) {
            current = current!.next;
        }
        return current;
    }

    // LeetCode 876 - Middle of the Linked List (Fast and Slow Pointer Approach)
    middleNodeFastAndSlowPointerApproach(head: ListNode | null): ListNode | null {
        let slow = head, fast = head;
        while (fast && fast.next) {
            slow = slow!.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // LeetCode 202 - Happy Number (HashSet Approach)
    getSumOfSquares(n: number): number {
        return String(n).split('').reduce((sum, digit) => sum + Number(digit) ** 2, 0);
    }

    isHappyHashSetApproach(n: number): boolean {
        const seen = new Set<number>();
        while (n !== 1 && !seen.has(n)) {
            seen.add(n);
            n = this.getSumOfSquares(n);
        }
        return n === 1;
    }

    // LeetCode 202 - Happy Number (Fast and Slow Pointer Approach)
    isHappyFastAndSlowPointersApproach(n: number): boolean {
        let slow = n;
        let fast = this.getSumOfSquares(n);
        while (fast !== 1 && slow !== fast) {
            slow = this.getSumOfSquares(slow);
            fast = this.getSumOfSquares(this.getSumOfSquares(fast));
        }
        return fast === 1;
    }
}