using System;
using System.Collections.Generic;
using System.Linq;

public class TopKElements {
    
    // K Largest Elements using Sorting
    public int[] KLargestElementsSortingApproach(int[] nums, int k) {
        Array.Sort(nums, (a, b) => b.CompareTo(a));
        return nums.Take(k).ToArray();
    }

    // K Largest Elements using Max Heap
    public int[] KLargestElementsMaxHeapApproach(int[] nums, int k) {
        PriorityQueue<int, int> maxHeap = new PriorityQueue<int, int>(Comparer<int>.Create((a, b) => b - a));
        foreach (var num in nums) {
            maxHeap.Enqueue(num, num);
        }
        var result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.Dequeue();
        }
        return result;
    }

    // K Largest Elements using Min Heap
    public int[] KLargestElementsMinHeapApproach(int[] nums, int k) {
        PriorityQueue<int, int> minHeap = new PriorityQueue<int, int>();
        for (int i = 0; i < k; i++) {
            minHeap.Enqueue(nums[i], nums[i]);
        }
        for (int i = k; i < nums.Length; i++) {
            minHeap.Enqueue(nums[i], nums[i]);
            if (minHeap.Count > k) {
                minHeap.Dequeue();
            }
        }
        var result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.Dequeue();
        }
        return result;
    }

    // Top K Frequent Elements using Sorting
    public int[] TopKFrequentElementsSortingApproach(int[] nums, int k) {
        var frequencyMap = new Dictionary<int, int>();
        foreach (var num in nums) {
            if (!frequencyMap.ContainsKey(num)) {
                frequencyMap[num] = 0;
            }
            frequencyMap[num]++;
        }

        var sortedEntries = frequencyMap.OrderByDescending(e => e.Value).Take(k).Select(e => e.Key).ToArray();
        return sortedEntries;
    }

    // Top K Frequent Elements using Min Heap
    public int[] TopKFrequentElementsMinHeapApproach(int[] nums, int k) {
        var frequencyMap = new Dictionary<int, int>();
        foreach (var num in nums) {
            if (!frequencyMap.ContainsKey(num)) {
                frequencyMap[num] = 0;
            }
            frequencyMap[num]++;
        }

        var minHeap = new PriorityQueue<int, int>(Comparer<int>.Create((a, b) => a.CompareTo(b)));
        foreach (var entry in frequencyMap) {
            minHeap.Enqueue(entry.Key, entry.Value);
            if (minHeap.Count > k) {
                minHeap.Dequeue();
            }
        }

        var result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.Dequeue();
        }
        return result;
    }

    // K Closest Points to Origin using Max Heap
    private int GetDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    public int[][] KClosestPointsToOriginMaxHeapApproach(int[][] points, int k) {
        PriorityQueue<int[], int> maxHeap = new PriorityQueue<int[], int>(Comparer<int>.Create((a, b) => b - a));
        foreach (var point in points) {
            maxHeap.Enqueue(point, GetDistance(point));
            if (maxHeap.Count > k) {
                maxHeap.Dequeue();
            }
        }
        var result = new int[k][];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.Dequeue();
        }
        return result;
    }
}