#include <iostream>
#include <vector>
#include <unordered_set>
#include <algorithm>

using namespace std;

class SlidingWindow {
public:
    double findMaxAverageBruteForce(vector<int>& nums, int k) {
        int n = nums.size();
        double maxAvg = INT_MIN;

        for (int i = 0; i <= n - k; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += nums[j];
            }
            maxAvg = max(maxAvg, (double)sum / k);
        }
        return maxAvg;
    }

    double findMaxAverageSlidingWindow(vector<int>& nums, int k) {
        int n = nums.size();
        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int maxSum = sum;

        for (int i = k; i < n; i++) {
            sum += nums[i];
            sum -= nums[i - k];
            maxSum = max(maxSum, sum);
        }

        return (double)maxSum / k;
    }

    int lengthOfLongestSubstringSlidingWindow(string s) {
        unordered_set<char> seen;
        int maxLength = 0, left = 0;

        for (int right = 0; right < s.size(); right++) {
            while (seen.count(s[right])) {
                seen.erase(s[left]);
                left++;
            }
            seen.insert(s[right]);
            maxLength = max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    int lengthOfLongestSubstringSlidingWindowFrequencyArray(string s) {
        vector<int> freq(128, 0);
        int maxLength = 0, left = 0;

        for (int right = 0; right < s.size(); right++) {
            freq[s[right]]++;

            while (freq[s[right]] > 1) {
                freq[s[left]]--;
                left++;
            }

            maxLength = max(maxLength, right - left + 1);
        }
        return maxLength;
    }
};