class Solution {
    public int countMaxOrSubsets(int[] nums) {
    int max = 0;
    for(int num: nums){
        max |= num;
    }
    int [] count = new int[1];
    backtrack(nums, 0,0, max, count);
    return count[0];
    }
    public void backtrack(int [] nums, int index, int currOr, int maxOr, int [] count){
        if(currOr == maxOr){
            count[0]++;
        }
        for(int i=index; i<nums.length;i++){
            backtrack(nums,i+1, currOr | nums[i], maxOr, count);
        }
    }
}