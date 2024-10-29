#include <iostream>
#include <vector>
#include <queue>
#include <unordered_map>
#include <algorithm>

using namespace std;

class TopKElements {
public:
    // K Largest Elements using Sorting
    vector<int> kLargestElementsSortingAppraoch(vector<int>& nums, int k) {
        sort(nums.begin(), nums.end(), greater<int>());
        return vector<int>(nums.begin(), nums.begin() + k);
    }

    // K Largest Elements using Max Heap
    vector<int> kLargestElementsMaxHeapAppraoch(vector<int>& nums, int k) {
        priority_queue<int> maxHeap(nums.begin(), nums.end());
        vector<int> result;
        for (int i = 0; i < k; i++) {
            result.push_back(maxHeap.top());
            maxHeap.pop();
        }
        return result;
    }

    // K Largest Elements using Min Heap
    vector<int> kLargestElementsMinHeapAppraoch(vector<int>& nums, int k) {
        priority_queue<int, vector<int>, greater<int>> minHeap;
        for (int i = 0; i < k; i++) {
            minHeap.push(nums[i]);
        }
        for (int i = k; i < nums.size(); i++) {
            minHeap.push(nums[i]);
            if (minHeap.size() > k) {
                minHeap.pop();
            }
        }
        vector<int> result;
        while (!minHeap.empty()) {
            result.push_back(minHeap.top());
            minHeap.pop();
        }
        return result;
    }

    // Top K Frequent Elements using Sorting
    vector<int> topKFrequentElementsSortingApproach(vector<int>& nums, int k) {
        unordered_map<int, int> frequencyMap;
        for (int num : nums) {
            frequencyMap[num]++;
        }

        vector<pair<int, int>> freqVec(frequencyMap.begin(), frequencyMap.end());
        sort(freqVec.begin(), freqVec.end(), [](pair<int, int>& a, pair<int, int>& b) {
            return b.second < a.second;
        });

        vector<int> result;
        for (int i = 0; i < k; i++) {
            result.push_back(freqVec[i].first);
        }
        return result;
    }

    // Top K Frequent Elements using Min Heap
    vector<int> topKFrequentElementsMinHeapApproach(vector<int>& nums, int k) {
        unordered_map<int, int> frequencyMap;
        for (int num : nums) {
            frequencyMap[num]++;
        }

        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> minHeap;
        for (auto& entry : frequencyMap) {
            minHeap.push({entry.second, entry.first});
            if (minHeap.size() > k) {
                minHeap.pop();
            }
        }

        vector<int> result;
        while (!minHeap.empty()) {
            result.push_back(minHeap.top().second);
            minHeap.pop();
        }
        return result;
    }

    // K Closest Points to Origin using Max Heap
    int getDistance(vector<int>& point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    vector<vector<int>> kClosestPointsToOriginMaxHeapApproach(vector<vector<int>>& points, int k) {
        priority_queue<pair<int, vector<int>>> maxHeap;
        for (vector<int>& point : points) {
            maxHeap.push({getDistance(point), point});
            if (maxHeap.size() > k) {
                maxHeap.pop();
            }
        }

        vector<vector<int>> result;
        while (!maxHeap.empty()) {
            result.push_back(maxHeap.top().second);
            maxHeap.pop();
        }
        return result;
    }
};