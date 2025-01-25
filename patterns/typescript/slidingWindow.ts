class SlidingWindow {
    // Brute Force Approach - O(n * k)
    findMaxAverageBruteForce(nums: number[], k: number): number {
        let maxAvg = -Infinity;

        for (let i = 0; i <= nums.length - k; i++) {
            let sum = 0;
            for (let j = i; j < i + k; j++) {
                sum += nums[j];
            }
            maxAvg = Math.max(maxAvg, sum / k);
        }
        return maxAvg;
    }

    // Sliding Window Approach - O(n)
    findMaxAverageSlidingWindow(nums: number[], k: number): number {
        let sum = nums.slice(0, k).reduce((a, b) => a + b, 0);
        let maxSum = sum;

        for (let i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum / k;
    }

    // Sliding Window for Longest Substring Without Repeating Characters
    lengthOfLongestSubstringSlidingWindow(s: string): number {
        let seen = new Set<string>();
        let maxLength = 0, left = 0;

        for (let right = 0; right < s.length; right++) {
            while (seen.has(s[right])) {
                seen.delete(s[left]);
                left++;
            }
            seen.add(s[right]);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    // Sliding Window using Frequency Array
    lengthOfLongestSubstringSlidingWindowFrequencyArray(s: string): number {
        let freq = new Array(128).fill(0);
        let maxLength = 0, left = 0;

        for (let right = 0; right < s.length; right++) {
            freq[s.charCodeAt(right)]++;

            while (freq[s.charCodeAt(right)] > 1) {
                freq[s.charCodeAt(left)]--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}