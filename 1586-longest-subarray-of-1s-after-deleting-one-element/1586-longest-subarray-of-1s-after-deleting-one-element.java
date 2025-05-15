class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0, zeros = 0, maxlen = 0;
        for(int rgt = 0; rgt<nums.length; rgt++){
            if(nums[rgt] == 0){
                zeros++;
            }
            while(zeros > 1){
                if(nums[left] == 0){
                    zeros--;
                }
                left++;
            }
            maxlen = Math.max(maxlen, rgt - left);
        }
        return maxlen;
    }
}