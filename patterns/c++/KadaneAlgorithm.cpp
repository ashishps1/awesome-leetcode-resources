#include <vector>
#include <algorithm> // For std::max

class KadaneAlgorithm {
public:
    int maxSubArray(std::vector<int>& nums) {
        int currentSum = nums[0]; // Start with the first element
        int maxSum = nums[0];     // Initialize maxSum with the first element

        // Traverse the array from the second element
        for (size_t i = 1; i < nums.size(); i++) {
            // If currentSum is negative, reset to current element
            currentSum = std::max(nums[i], currentSum + nums[i]);
            // Update maxSum if currentSum is greater
            maxSum = std::max(maxSum, currentSum);
        }
        return maxSum;
    }
};