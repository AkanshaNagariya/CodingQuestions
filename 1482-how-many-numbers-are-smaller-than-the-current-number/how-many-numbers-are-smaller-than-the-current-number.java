class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int ans [] = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            int cnt = 0;
            for(int j=0; j<nums.length;j++){
                if(j != i && nums[j] < nums[i]){
                    cnt++;
                }
            }
            ans[i] = cnt;
            cnt = 0;
        }
        return ans;
    }
}