#include <unordered_set>
using namespace std;

class ListNode {
public:
    int val;
    ListNode* next;
    ListNode(int x) : val(x), next(nullptr) {}
};

class FastAndSlowPointers {
public:
    // LeetCode 141 - Linked List Cycle (HashSet Approach)
    bool hasCycleHashSetApproach(ListNode* head) {
        unordered_set<ListNode*> visited;
        ListNode* current = head;
        while (current != nullptr) {
            if (visited.find(current) != visited.end()) {
                return true; // Cycle detected
            }
            visited.insert(current);
            current = current->next;
        }
        return false; // No cycle
    }

    // LeetCode 141 - Linked List Cycle (Fast and Slow Pointer Approach)
    bool hasCycleFastAndSlowPointersApproach(ListNode* head) {
        if (head == nullptr || head->next == nullptr) {
            return false;
        }
        ListNode* slow = head;
        ListNode* fast = head;
        while (fast != nullptr && fast->next != nullptr) {
            slow = slow->next;
            fast = fast->next->next;
            if (slow == fast) {
                return true; // Cycle detected
            }
        }
        return false; // No cycle
    }

    // LeetCode 876 - Middle of the Linked List (Counting Approach)
    ListNode* middleNodeCountingApproach(ListNode* head) {
        int count = 0;
        ListNode* current = head;
        while (current != nullptr) {
            count++;
            current = current->next;
        }
        current = head;
        for (int i = 0; i < count / 2; i++) {
            current = current->next;
        }
        return current;
    }

    // LeetCode 876 - Middle of the Linked List (Fast and Slow Pointer Approach)
    ListNode* middleNodeFastAndSlowPointerApproach(ListNode* head) {
        ListNode* slow = head;
        ListNode* fast = head;
        while (fast != nullptr && fast->next != nullptr) {
            slow = slow->next;
            fast = fast->next->next;
        }
        return slow;
    }

    // LeetCode 202 - Happy Number (HashSet Approach)
    int getSumOfSquares(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    bool isHappyHashSetApproach(int n) {
        unordered_set<int> seen;
        while (n != 1 && seen.find(n) == seen.end()) {
            seen.insert(n);
            n = getSumOfSquares(n);
        }
        return n == 1;
    }

    // LeetCode 202 - Happy Number (Fast and Slow Pointer Approach)
    bool isHappyFastAndSlowPointersApproach(int n) {
        int slow = n;
        int fast = getSumOfSquares(n);
        while (fast != 1 && slow != fast) {
            slow = getSumOfSquares(slow);
            fast = getSumOfSquares(getSumOfSquares(fast));
        }
        return fast == 1;
    }
};