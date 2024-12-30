package main

import "math"

func maxSubArray(nums []int) int {
	currentSum := nums[0]
	maxSum := nums[0]

	for i := 1; i < len(nums); i++ {
		currentSum = int(math.Max(float64(nums[i]), float64(currentSum+nums[i])))
		maxSum = int(math.Max(float64(maxSum), float64(currentSum)))
	}

	return maxSum
}
