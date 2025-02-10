using System;
using System.Collections.Generic;

public class MonotonicStack {
    public int[] NextGreaterElement(int[] nums) {
        int n = nums.Length;
        int[] result = new int[n];
        Array.Fill(result, -1); // Default to -1 if no greater element exists
        Stack<int> stack = new Stack<int>(); // Stack stores indices

        for (int i = 0; i < n; i++) {
            while (stack.Count > 0 && nums[i] > nums[stack.Peek()]) {
                int index = stack.Pop();
                result[index] = nums[i];
            }
            stack.Push(i);
        }
        return result;
    }

    public int[] DailyTemperatures(int[] temperatures) {
        int n = temperatures.Length;
        int[] result = new int[n]; // Result array initialized with 0s
        Stack<int> stack = new Stack<int>(); // Monotonic decreasing stack

        for (int i = 0; i < n; i++) {
            while (stack.Count > 0 && temperatures[i] > temperatures[stack.Peek()]) {
                int prevIndex = stack.Pop();
                result[prevIndex] = i - prevIndex;
            }
            stack.Push(i);
        }
        return result;
    }
}