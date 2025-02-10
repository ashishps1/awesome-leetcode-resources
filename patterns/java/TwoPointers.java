package patterns.java;

public class TwoPointers {

    public void moveZeroesTwoPointers(int[] nums) {
        int left = 0; // Pointer for placing non-zero elements

        // Iterate with right pointer
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                // Swap elements if right pointer finds a non-zero
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++; // Move left pointer forward
            }
        }
    }

    public int maxAreaBruteForce(int[] height) {
        int n = height.length;
        int maxArea = 0;

        // Check all pairs (i, j)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Height of the container
                int minHeight = Math.min(height[i], height[j]);
                int width = j - i; // Distance between lines
                int area = minHeight * width; // Compute water contained

                maxArea = Math.max(maxArea, area); // Update max water
            }
        }
        return maxArea;
    }

    public int maxAreaTwoPointers(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        // Move pointers toward each other
        while (left <= right) {
            int width = right - left; // Distance between lines
            int minHeight = Math.min(height[left], height[right]);
            int area = minHeight * width; // Compute water contained

            maxArea = Math.max(maxArea, area); // Update max water

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