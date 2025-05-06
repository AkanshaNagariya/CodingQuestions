class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int bitindex = 0; bitindex<32; bitindex++){
             int cnt = 0;
            for(int i=0 ; i<nums.length; i++){
            if ((nums[i] & (1 << bitindex)) != 0){
                cnt++;
            }
            }
            if(cnt % 3 == 1){
                ans = ans | (1<<bitindex);
            }
        }
        return ans;
    }
}