class Solution {
    public int removeDuplicates(int[] nums) {
        int ans [] = new int[nums.length];
        ans[0] = nums[0];
        int ptr = 0;
        for(int i=1; i<nums.length; i++){
            if(nums[i] != ans[ptr]){
                ptr++;
                ans[ptr] = nums[i];
            } 
        }
        for(int i=0; i<ans.length; i++){
            nums[i] = ans[i];
        }
        return ptr+1;
    }
}