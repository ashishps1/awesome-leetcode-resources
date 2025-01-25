package patterns.java;

import java.util.HashSet;

public class SlidingWindow {
    public double findMaxAverageBruteForce(int[] nums, int k) {
        int n = nums.length;
        double maxAvg = Integer.MIN_VALUE;

        // Iterate through all possible subarrays of length k
        for (int i = 0; i <= n - k; i++) {
            int sum = 0;

            // Calculate sum of subarray starting at index i
            for (int j = i; j < i + k; j++) {
                sum += nums[j];
            }

            // Compute average and update maxAvg
            maxAvg = Math.max(maxAvg, (double) sum / k);
        }
        return maxAvg;
    }

    public double findMaxAverageSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        
        // Compute the sum of the first 'k' elements
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        
        // Initialize maxSum as the sum of the first window
        int maxSum = sum;

        // Slide the window across the array
        for (int i = k; i < n; i++) {
            sum += nums[i];      // Add new element entering window
            sum -= nums[i - k];  // Remove element leaving window
            maxSum = Math.max(maxSum, sum); // Update maxSum
        }
        
        // Return maximum average
        return (double) maxSum / k;
    }

    public int lengthOfLongestSubstringSlidingWindow(String s) {
        int n = s.length();
        HashSet<Character> seen = new HashSet<>(); // Store characters in the current window
        int maxLength = 0;
        int left = 0;        

        // Expand window by moving 'right'
        for (int right = 0; right < n; right++) {
            // If a duplicate is found, shrink the window from the left
            while (seen.contains(s.charAt(right))) {
                seen.remove(s.charAt(left));
                left++;
            }
            // Add current character to window and update max length
            seen.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public int lengthOfLongestSubstringSlidingWindowFrequencyArray(String s) {
        int n = s.length();
        int[] freq = new int[128]; // ASCII character frequency array
        int maxLength = 0;
        int left = 0;        

        // Expand window by moving 'right'
        for (int right = 0; right < n; right++) {
            char currentChar = s.charAt(right);
            freq[currentChar]++; // Increase frequency of the current character

            // If there is a duplicate, shrink the window from the left
            while (freq[currentChar] > 1) {
                freq[s.charAt(left)]--; // Remove character at left pointer
                left++; // Shrink window
            }

            // Update maximum window size
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }    
}