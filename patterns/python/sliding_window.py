class SlidingWindow:
    def find_max_average_brute_force(self, nums, k):
        max_avg = float('-inf')

        for i in range(len(nums) - k + 1):
            max_avg = max(max_avg, sum(nums[i:i + k]) / k)

        return max_avg

    def find_max_average_sliding_window(self, nums, k):
        sum_window = sum(nums[:k])
        max_sum = sum_window

        for i in range(k, len(nums)):
            sum_window += nums[i] - nums[i - k]
            max_sum = max(max_sum, sum_window)

        return max_sum / k

    def length_of_longest_substring_sliding_window(self, s):
        seen = set()
        max_length = left = 0

        for right in range(len(s)):
            while s[right] in seen:
                seen.remove(s[left])
                left += 1
            seen.add(s[right])
            max_length = max(max_length, right - left + 1)

        return max_length

    def length_of_longest_substring_sliding_window_frequency_array(self, s):
        freq = [0] * 128
        max_length = left = 0

        for right in range(len(s)):
            freq[ord(s[right])] += 1

            while freq[ord(s[right])] > 1:
                freq[ord(s[left])] -= 1
                left += 1

            max_length = max(max_length, right - left + 1)

        return max_length