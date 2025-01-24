class MonotonicStack:
    def next_greater_element(self, nums):
        n = len(nums)
        result = [-1] * n  # Default to -1 if no greater element exists
        stack = []  # Stack stores indices

        for i in range(n):
            while stack and nums[i] > nums[stack[-1]]:
                index = stack.pop()
                result[index] = nums[i]
            stack.append(i)
        
        return result

    def daily_temperatures(self, temperatures):
        n = len(temperatures)
        result = [0] * n  # Result array initialized with 0s
        stack = []  # Monotonic decreasing stack

        for i in range(n):
            while stack and temperatures[i] > temperatures[stack[-1]]:
                prev_index = stack.pop()
                result[prev_index] = i - prev_index
            stack.append(i)

        return result