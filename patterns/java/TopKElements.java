package patterns.java;

import patterns.java.FastAndSlowPointers.ListNode;
import java.util.*;

public class TopKElements {

    /*
    * ********** K Largest Elements **********
    */
    
    public int[] kLargestElementsSortingAppraoch(int[] nums, int k) {
        // Step 1: Sort the array in descending order
        Integer[] numsArray = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(numsArray, Collections.reverseOrder());

        // Step 2: Extract the first K elements
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = numsArray[i];
        }
        return result;
    }

    public int[] kLargestElementsMaxHeapAppraoch(int[] nums, int k) {
        // Max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Add all numbers to the max heap
        for (int num : nums) {
            maxHeap.add(num);
        }

        // Extract the top K largest elements
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();  // Extracts the largest element
        }
        return result;
    }

    public int[] kLargestElementsMinHeapAppraoch(int[] nums, int k) {
        // Min heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add first K elements into the min heap
        for(int i = 0; i < k; i++) {
            minHeap.add(nums[i]);
        }

        // Process the remaining elements
        for (int i = k; i < nums.length; i++) {
            minHeap.add(nums[i]);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Extract the top K largest elements from the min heap
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }
        return result;
    }

    /*
    * ********** LeetCode 347 - Top K Frequent Elements (https://leetcode.com/problems/top-k-frequent-elements/description/) **********
    */

    public int[] topKFrequentElementsSortingApproach(int[] nums, int k) {
        // Step 1: Build the frequency map
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Sort the entries by frequency in descending order
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());
        entryList.sort((a, b) -> b.getValue() - a.getValue());

        // Step 3: Extract the top K elements
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = entryList.get(i).getKey();
        }

        return result;
    }

    public int[] topKFrequentElementsMinHeapApproach(int[] nums, int k) {
        // Step 1: Build the frequency map
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Use a min heap to keep track of the top K elements
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
            (a, b) -> a.getValue() - b.getValue()  // Compare by frequency
        );

        // Step 3: Add each entry to the heap, and maintain size K
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k) {
                minHeap.poll();  // Remove the element with the lowest frequency
            }
        }

        // Step 4: Extract the elements from the heap
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll().getKey();  // Get the element (key) from the heap
        }

        return result;
    }

    /*
    * ********** LeetCode 973 - K Closest Points to Origin (https://leetcode.com/problems/k-closest-points-to-origin/description/) **********
    */
    private int getDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];  // Squared distance to avoid floating-point operations
    }

    public int[][] kClosestPointsToOriginMaxHeapApproach(int[][] points, int k) {
        // Max heap with custom comparator to compare by distance
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> getDistance(b) - getDistance(a));

        // Iterate through all points
        for (int[] point : points) {
            maxHeap.add(point);  // Add the current point to the heap

            // If the heap exceeds size K, remove the farthest point
            if (maxHeap.size() > k) {
                maxHeap.poll();  // Remove the point with the largest distance (root of max heap)
            }
        }

        // Convert the remaining points in the heap to the result array
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }

        return result;
    }
}