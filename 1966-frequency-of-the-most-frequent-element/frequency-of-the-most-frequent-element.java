
public class Solution {
    public int maxFrequency(int[] nums, int k) {
        // Step 1: Sort the array in ascending order
        Arrays.sort(nums);
        
        int left = 0;
        long total = 0;
        int maxFreq = 0;

        // Step 2: Use sliding window with 'right' pointer
        for (int right = 0; right < nums.length; right++) {
            // Add current element to total sum of window
            total += nums[right];

            // Step 3: Check if total operations needed exceed k
            // We want to make all elements in window equal to nums[right]
            while ((long) nums[right] * (right - left + 1) - total > k) {
                // Shrink window from left
                total -= nums[left];
                left++;
            }

            // Step 4: Update max frequency
            maxFreq = Math.max(maxFreq, right - left + 1);
        }

        return maxFreq;
    }
}
