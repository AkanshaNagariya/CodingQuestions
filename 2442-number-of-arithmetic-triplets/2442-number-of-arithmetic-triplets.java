class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int cnt = 0; 
        for(int i=0; i<nums.length-2; i++){
            for(int j=i+1; j<nums.length;j++){
                for(int k=j+1; k<nums.length; k++){
                    if(nums[j]-nums[i] == diff && nums[k]-nums[j]==diff){
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}