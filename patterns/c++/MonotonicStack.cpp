#include <vector>
#include <stack>

using namespace std;

class MonotonicStack {
public:
    vector<int> nextGreaterElement(vector<int>& nums) {
        int n = nums.size();
        vector<int> result(n, -1); // Default to -1 if no greater element exists
        stack<int> stack; // Stack stores indices

        for (int i = 0; i < n; i++) {
            while (!stack.empty() && nums[i] > nums[stack.top()]) {
                int index = stack.top();
                stack.pop();
                result[index] = nums[i];
            }
            stack.push(i);
        }
        return result;
    }

    vector<int> dailyTemperatures(vector<int>& temperatures) {
        int n = temperatures.size();
        vector<int> result(n, 0);
        stack<int> stack; // Monotonic decreasing stack

        for (int i = 0; i < n; i++) {
            while (!stack.empty() && temperatures[i] > temperatures[stack.top()]) {
                int prevIndex = stack.top();
                stack.pop();
                result[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return result;
    }
};