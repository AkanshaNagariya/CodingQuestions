class Solution {
    public int dominantIndex(int[] nums) {
        int idx=-1,max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            boolean flag=true;
            for(int j=0;j<nums.length;j++){
                if(i==j||nums[j]==0){
                    continue;
                }
                else if(nums[i]/nums[j]<2){
                    flag=false;
                    break;
                }
            }
            if(flag&&nums[i]>max){
                idx=i;
            }
        }
        return idx;
    }
}