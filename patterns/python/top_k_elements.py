import heapq
from collections import Counter

class TopKElements:
    
    # K Largest Elements using Sorting
    def k_largest_elements_sorting_approach(self, nums, k):
        return sorted(nums, reverse=True)[:k]

    # K Largest Elements using Max Heap
    def k_largest_elements_max_heap_approach(self, nums, k):
        return heapq.nlargest(k, nums)

    # K Largest Elements using Min Heap
    def k_largest_elements_min_heap_approach(self, nums, k):
        min_heap = nums[:k]
        heapq.heapify(min_heap)
        for num in nums[k:]:
            heapq.heappush(min_heap, num)
            if len(min_heap) > k:
                heapq.heappop(min_heap)
        return [heapq.heappop(min_heap) for _ in range(k)][::-1]

    # Top K Frequent Elements using Sorting
    def top_k_frequent_elements_sorting_approach(self, nums, k):
        count = Counter(nums)
        return [num for num, freq in count.most_common(k)]

    # Top K Frequent Elements using Min Heap
    def top_k_frequent_elements_min_heap_approach(self, nums, k):
        count = Counter(nums)
        min_heap = []
        for num, freq in count.items():
            heapq.heappush(min_heap, (freq, num))
            if len(min_heap) > k:
                heapq.heappop(min_heap)
        return [heapq.heappop(min_heap)[1] for _ in range(k)][::-1]

    # K Closest Points to Origin using Max Heap
    def get_distance(self, point):
        return point[0] ** 2 + point[1] ** 2

    def k_closest_points_to_origin_max_heap_approach(self, points, k):
        max_heap = []
        for point in points:
            heapq.heappush(max_heap, (-self.get_distance(point), point))
            if len(max_heap) > k:
                heapq.heappop(max_heap)
        return [heapq.heappop(max_heap)[1] for _ in range(k)][::-1]