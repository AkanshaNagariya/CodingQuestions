class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Arrays.sort(nums);
        int first = 0, second = 0;
        int ans [] = new int[2];
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] == nums[i+1]){
                if(first == 0){
                    first = nums[i];
                    i++;
                } else {
                    second = nums[i];
                    i++;
                }
            }
        }
        ans[0] = first;
        ans[1] = second;
        return ans;
    }
}