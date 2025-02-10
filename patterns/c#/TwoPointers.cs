using System;

public class TwoPointers {
    // Move Zeroes using Two Pointers
    public void MoveZeroesTwoPointers(int[] nums) {
        int left = 0; // Pointer for placing non-zero elements

        // Iterate with right pointer
        for (int right = 0; right < nums.Length; right++) {
            if (nums[right] != 0) {
                // Swap elements if right pointer finds a non-zero
                (nums[left], nums[right]) = (nums[right], nums[left]);
                left++; // Move left pointer forward
            }
        }
    }

    // Brute Force approach for Container with Most Water
    public int MaxAreaBruteForce(int[] height) {
        int n = height.Length;
        int maxArea = 0;

        // Check all pairs (i, j)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Compute the minimum height and width
                int minHeight = Math.Min(height[i], height[j]);
                int width = j - i;
                int area = minHeight * width; // Compute water contained

                maxArea = Math.Max(maxArea, area); // Update max water
            }
        }
        return maxArea;
    }

    // Two Pointers approach for Container with Most Water
    public int MaxAreaTwoPointers(int[] height) {
        int left = 0, right = height.Length - 1;
        int maxArea = 0;

        // Move pointers toward each other
        while (left < right) {
            int width = right - left; // Distance between lines
            int minHeight = Math.Min(height[left], height[right]); // Compute height
            int area = minHeight * width; // Compute water contained

            maxArea = Math.Max(maxArea, area); // Update max water

            // Move the pointer pointing to the shorter height
            if (height[left] < height[right]) {
                left++; // Move left pointer forward
            } else {
                right--; // Move right pointer backward
            }
        }
        return maxArea;
    }
}