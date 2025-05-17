class Solution {
    public int splitArray(int[] nums, int k) {
     int low = Integer.MIN_VALUE;
     int high = 0;
      for(int i=0; i<nums.length; i++){
        low = Math.max(low, nums[i]);
        high += nums[i];
      }  
      int ans = -1;
      while(low<=high){
        int mid = low + (high - low)/2;
        int pieces = func(nums,mid);
        if(pieces <= k){
            ans = mid;
            high = mid-1;
        } else {
            low = mid+1;
        }
    }
    return ans;
    }
    static int func(int nums[], int mid){
        int sum = 0; int piece = 1;
        for(int num : nums){
            if(sum + num <= mid){
                sum += num;
            } else {
                piece++;
                sum = num;
            }
        }
        return piece;
    }
}