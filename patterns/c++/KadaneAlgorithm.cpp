#include <vector>
#include <algorithm> 

class KadaneAlgorithm {
public:
    int maxSubArray(std::vector<int>& nums) {
        int currentSum = nums[0]; 
        int maxSum = nums[0];     

        // Traverse the array from the second element
        for (size_t i = 1; i < nums.size(); i++) {
           
            currentSum = std::max(nums[i], currentSum + nums[i]);
           
            maxSum = std::max(maxSum, currentSum);
        }
        return maxSum;
    }
};