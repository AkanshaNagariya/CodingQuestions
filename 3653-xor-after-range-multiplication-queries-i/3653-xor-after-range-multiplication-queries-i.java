class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        for(int i=0; i<queries.length;i++){
           int l = queries[i][0], r = queries[i][1],  k = queries[i][2], v = queries[i][3];
            int idx = l;
            int mod = 1000000007;
            while(idx <= r){
                nums[idx] = (int)((1L * nums[idx] * v) % mod);
                idx += k;
            }
        }
        int xor = 0;
        for(int x : nums){
            xor = xor ^ x;
        }
        return xor;
    }
}