using System;
using System.Collections.Generic;

public class SlidingWindow {
    public double FindMaxAverageBruteForce(int[] nums, int k) {
        int n = nums.Length;
        double maxAvg = double.MinValue;

        for (int i = 0; i <= n - k; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += nums[j];
            }
            maxAvg = Math.Max(maxAvg, (double)sum / k);
        }
        return maxAvg;
    }

    public double FindMaxAverageSlidingWindow(int[] nums, int k) {
        int n = nums.Length;
        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int maxSum = sum;

        for (int i = k; i < n; i++) {
            sum += nums[i];
            sum -= nums[i - k];
            maxSum = Math.Max(maxSum, sum);
        }

        return (double)maxSum / k;
    }

    public int LengthOfLongestSubstringSlidingWindow(string s) {
        HashSet<char> seen = new HashSet<char>();
        int maxLength = 0, left = 0;

        for (int right = 0; right < s.Length; right++) {
            while (seen.Contains(s[right])) {
                seen.Remove(s[left]);
                left++;
            }
            seen.Add(s[right]);
            maxLength = Math.Max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public int LengthOfLongestSubstringSlidingWindowFrequencyArray(string s) {
        int[] freq = new int[128];
        int maxLength = 0, left = 0;

        for (int right = 0; right < s.Length; right++) {
            freq[s[right]]++;

            while (freq[s[right]] > 1) {
                freq[s[left]]--;
                left++;
            }

            maxLength = Math.Max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}