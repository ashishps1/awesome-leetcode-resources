class TwoPointers {
    // Move Zeroes using Two Pointers
    moveZeroesTwoPointers(nums: number[]): void {
        let left = 0; // Pointer for placing non-zero elements

        // Iterate with right pointer
        for (let right = 0; right < nums.length; right++) {
            if (nums[right] !== 0) {
                // Swap elements if right pointer finds a non-zero
                [nums[left], nums[right]] = [nums[right], nums[left]];
                left++; // Move left pointer forward
            }
        }
    }

    // Brute Force approach for Container with Most Water
    maxAreaBruteForce(height: number[]): number {
        let maxArea = 0;
        let n = height.length;

        // Check all pairs (i, j)
        for (let i = 0; i < n; i++) {
            for (let j = i + 1; j < n; j++) {
                // Compute the minimum height and width
                let minHeight = Math.min(height[i], height[j]);
                let width = j - i;
                let area = minHeight * width; // Compute water contained

                maxArea = Math.max(maxArea, area); // Update max water
            }
        }
        return maxArea;
    }

    // Two Pointers approach for Container with Most Water
    maxAreaTwoPointers(height: number[]): number {
        let left = 0, right = height.length - 1;
        let maxArea = 0;

        // Move pointers toward each other
        while (left < right) {
            let width = right - left; // Distance between lines
            let minHeight = Math.min(height[left], height[right]); // Compute height
            let area = minHeight * width; // Compute water contained

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