package main

import (
	"math"
)

// Brute Force Approach - O(n * k)
func findMaxAverageBruteForce(nums []int, k int) float64 {
	n := len(nums)
	maxAvg := math.Inf(-1)

	for i := 0; i <= n-k; i++ {
		sum := 0
		for j := i; j < i+k; j++ {
			sum += nums[j]
		}
		maxAvg = math.Max(maxAvg, float64(sum)/float64(k))
	}
	return maxAvg
}

// Sliding Window Approach - O(n)
func findMaxAverageSlidingWindow(nums []int, k int) float64 {
	sum := 0
	for i := 0; i < k; i++ {
		sum += nums[i]
	}

	maxSum := sum

	for i := k; i < len(nums); i++ {
		sum += nums[i] - nums[i-k]
		if sum > maxSum {
			maxSum = sum
		}
	}

	return float64(maxSum) / float64(k)
}

// Sliding Window for Longest Substring Without Repeating Characters
func lengthOfLongestSubstringSlidingWindow(s string) int {
	seen := make(map[byte]bool)
	maxLength, left := 0, 0

	for right := 0; right < len(s); right++ {
		for seen[s[right]] {
			delete(seen, s[left])
			left++
		}
		seen[s[right]] = true
		maxLength = max(maxLength, right-left+1)
	}
	return maxLength
}

// Sliding Window using Frequency Array
func lengthOfLongestSubstringSlidingWindowFrequencyArray(s string) int {
	freq := make([]int, 128)
	maxLength, left := 0, 0

	for right := 0; right < len(s); right++ {
		freq[s[right]]++

		for freq[s[right]] > 1 {
			freq[s[left]]--
			left++
		}

		maxLength = max(maxLength, right-left+1)
	}
	return maxLength
}

// Helper function to get max of two numbers
func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
