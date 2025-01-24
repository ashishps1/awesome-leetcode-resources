package patterns.java;

import java.util.Arrays;
import java.util.Stack;

public class MonotonicStack {

    public int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        int[] result = new int[n]; // Output array
        Arrays.fill(result, -1); // Default to -1 if no greater element exists
        Stack<Integer> stack = new Stack<>(); // Stack stores indices

        // Iterate through the array
        for (int i = 0; i < n; i++) {
            // While stack is not empty and current element is greater than stack top
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int index = stack.pop(); // Pop the top element
                result[index] = nums[i]; // The current element is the Next Greater Element
            }
            stack.push(i); // Push the current index onto the stack
        }
        return result;
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n]; // Result array initialized with 0s
        Stack<Integer> stack = new Stack<>(); // Monotonic decreasing stack (stores indices)

        // Iterate through the temperature array
        for (int i = 0; i < n; i++) {
            // While stack is not empty AND the current temperature is warmer than the temperature at stack top
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop(); // Pop the previous day's index
                result[prevIndex] = i - prevIndex; // Calculate the wait time
            }
            stack.push(i); // Push current index onto the stack
        }

        return result; // Return the computed results
    }    
}