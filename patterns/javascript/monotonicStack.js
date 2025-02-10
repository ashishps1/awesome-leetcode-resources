class MonotonicStack {
    nextGreaterElement(nums) {
        let n = nums.length;
        let result = new Array(n).fill(-1); // Default to -1 if no greater element exists
        let stack = []; // Stack stores indices

        for (let i = 0; i < n; i++) {
            while (stack.length > 0 && nums[i] > nums[stack[stack.length - 1]]) {
                let index = stack.pop();
                result[index] = nums[i];
            }
            stack.push(i);
        }
        return result;
    }

    dailyTemperatures(temperatures) {
        let n = temperatures.length;
        let result = new Array(n).fill(0); // Result array initialized with 0s
        let stack = []; // Monotonic decreasing stack

        for (let i = 0; i < n; i++) {
            while (stack.length > 0 && temperatures[i] > temperatures[stack[stack.length - 1]]) {
                let prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return result;
    }
}