class Solution {
    public int smallestIndex(int[] nums) {
        
        for(int id = 0; id < nums.length; id++){
            int k = Math.abs(nums[id]);
            int totalsum = 0;
            for(; k > 0; k /= 10){
                totalsum += k % 10;
            }
            if(totalsum == id){
                return id;
            }
        }
        return -1;
    }
}