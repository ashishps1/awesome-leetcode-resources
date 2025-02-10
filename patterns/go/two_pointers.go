package main

// Move Zeroes using Two Pointers
func moveZeroesTwoPointers(nums []int) {
	left := 0 // Pointer for placing non-zero elements

	// Iterate with right pointer
	for right := 0; right < len(nums); right++ {
		if nums[right] != 0 {
			// Swap elements if right pointer finds a non-zero
			nums[left], nums[right] = nums[right], nums[left]
			left++ // Move left pointer forward
		}
	}
}

// Brute Force approach for Container with Most Water
func maxAreaBruteForce(height []int) int {
	n := len(height)
	maxArea := 0

	// Check all pairs (i, j)
	for i := 0; i < n; i++ {
		for j := i + 1; j < n; j++ {
			// Compute the minimum height and width
			minHeight := min(height[i], height[j])
			width := j - i
			area := minHeight * width // Compute water contained

			if area > maxArea {
				maxArea = area // Update max water
			}
		}
	}
	return maxArea
}

// Two Pointers approach for Container with Most Water
func maxAreaTwoPointers(height []int) int {
	left, right := 0, len(height)-1
	maxArea := 0

	// Move pointers toward each other
	for left < right {
		width := right - left                         // Distance between lines
		minHeight := min(height[left], height[right]) // Compute height
		area := minHeight * width                     // Compute water contained

		if area > maxArea {
			maxArea = area // Update max water
		}

		// Move the pointer pointing to the shorter height
		if height[left] < height[right] {
			left++ // Move left pointer forward
		} else {
			right-- // Move right pointer backward
		}
	}
	return maxArea
}

// Helper function to return the minimum of two integers
func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}
