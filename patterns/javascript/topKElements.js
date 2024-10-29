class TopKElements {

    // K Largest Elements using Sorting
    kLargestElementsSortingApproach(nums, k) {
        nums.sort((a, b) => b - a);
        return nums.slice(0, k);
    }

    // K Largest Elements using Max Heap
    kLargestElementsMaxHeapApproach(nums, k) {
        const maxHeap = new MaxPriorityQueue({ priority: x => x });
        for (const num of nums) {
            maxHeap.enqueue(num);
        }
        const result = [];
        for (let i = 0; i < k; i++) {
            result.push(maxHeap.dequeue().element);
        }
        return result;
    }

    // K Largest Elements using Min Heap
    kLargestElementsMinHeapApproach(nums, k) {
        const minHeap = new MinPriorityQueue({ priority: x => x });
        for (let i = 0; i < k; i++) {
            minHeap.enqueue(nums[i]);
        }
        for (let i = k; i < nums.length; i++) {
            minHeap.enqueue(nums[i]);
            if (minHeap.size() > k) {
                minHeap.dequeue();
            }
        }
        const result = [];
        for (let i = 0; i < k; i++) {
            result.push(minHeap.dequeue().element);
        }
        return result;
    }

    // Top K Frequent Elements using Sorting
    topKFrequentElementsSortingApproach(nums, k) {
        const frequencyMap = new Map();
        nums.forEach(num => frequencyMap.set(num, (frequencyMap.get(num) || 0) + 1));
        return Array.from(frequencyMap)
            .sort((a, b) => b[1] - a[1])
            .slice(0, k)
            .map(entry => entry[0]);
    }

    // Top K Frequent Elements using Min Heap
    topKFrequentElementsMinHeapApproach(nums, k) {
        const frequencyMap = new Map();
        nums.forEach(num => frequencyMap.set(num, (frequencyMap.get(num) || 0) + 1));
        const minHeap = new MinPriorityQueue({ priority: x => x[1] });
        frequencyMap.forEach((value, key) => {
            minHeap.enqueue([key, value]);
            if (minHeap.size() > k) {
                minHeap.dequeue();
            }
        });
        const result = [];
        for (let i = 0; i < k; i++) {
            result.push(minHeap.dequeue().element[0]);
        }
        return result;
    }

    // K Closest Points to Origin using Max Heap
    getDistance(point) {
        return point[0] ** 2 + point[1] ** 2;
    }

    kClosestPointsToOriginMaxHeapApproach(points, k) {
        const maxHeap = new MaxPriorityQueue({ priority: point => -this.getDistance(point) });
        points.forEach(point => {
            maxHeap.enqueue(point);
            if (maxHeap.size() > k) {
                maxHeap.dequeue();
            }
        });
        const result = [];
        for (let i = 0; i < k; i++) {
            result.push(maxHeap.dequeue().element);
        }
        return result;
    }
}