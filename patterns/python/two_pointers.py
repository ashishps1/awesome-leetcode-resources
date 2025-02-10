class TwoPointers:
    # Move Zeroes using Two Pointers
    def move_zeroes_two_pointers(self, nums):
        left = 0  # Pointer for placing non-zero elements

        # Iterate with right pointer
        for right in range(len(nums)):
            if nums[right] != 0:
                # Swap elements if right pointer finds a non-zero
                nums[left], nums[right] = nums[right], nums[left]
                left += 1  # Move left pointer forward

    # Brute Force approach for Container with Most Water
    def max_area_brute_force(self, height):
        n = len(height)
        max_area = 0

        # Check all pairs (i, j)
        for i in range(n):
            for j in range(i + 1, n):
                # Compute the minimum height and width
                min_height = min(height[i], height[j])
                width = j - i
                area = min_height * width  # Compute water contained

                max_area = max(max_area, area)  # Update max water
        return max_area

    # Two Pointers approach for Container with Most Water
    def max_area_two_pointers(self, height):
        left, right = 0, len(height) - 1
        max_area = 0

        # Move pointers toward each other
        while left < right:
            width = right - left  # Distance between lines
            min_height = min(height[left], height[right])  # Compute height
            area = min_height * width  # Compute water contained

            max_area = max(max_area, area)  # Update max water

            # Move the pointer pointing to the shorter height
            if height[left] < height[right]:
                left += 1  # Move left pointer forward
            else:
                right -= 1  # Move right pointer backward

        return max_area