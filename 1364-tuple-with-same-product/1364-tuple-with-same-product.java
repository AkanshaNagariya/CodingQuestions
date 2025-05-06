class Solution {
    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int prod = nums[i] *nums[j];
                mp.put(prod, mp.getOrDefault(prod,0)+1);
            }
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            int x = entry.getValue();
            int comb  =  (x*(x-1))/2;
            ans += 8 * comb;
        }
        return ans;
    }
}