class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int maxlength = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            mp.put(arr[i],i);
        }
        int [][] dp = new int[arr.length][arr.length];
        for(int i=2; i<arr.length;i++){
            for(int j=i-1; j>=0; j--){
                int diff = arr[i] - arr[j];
                if(mp.containsKey(diff) && mp.get(diff) < j){
                    dp[i][j] = Math.max(dp[i][j] , dp[j][mp.get(diff)]+ 1);

                    maxlength = Math.max(maxlength, dp[i][j]);
                }
            }
        }
        return maxlength > 0 ? maxlength + 2 : maxlength;
    }
}