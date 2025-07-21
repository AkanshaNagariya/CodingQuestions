class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int eve = 0, odd = 0;
        int [] res = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            if(nums[i] % 2 == 0){
                eve++;
            } else {
                odd++;
            }
        }
        int j =  0;
        int k = nums.length - odd;
        for(int i=0; i<nums.length; i++){
            if(nums[i] % 2 == 0){
                res[j] = nums[i];
                j++;
            } else {
                res[k] = nums[i];
                k++;
            }
        }
        return res;
       } 
    }
