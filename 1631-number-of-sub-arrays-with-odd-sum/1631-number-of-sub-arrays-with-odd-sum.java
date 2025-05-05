class Solution {
    public int numOfSubarrays(int[] arr) {
           int MOD = 1_000_000_007;
        int oddCount = 0, evenCount = 1; // evenCount starts as 1 for empty subarray
        int sum = 0, count = 0;

        for (int num : arr) {
            sum += num;

            if (sum % 2 == 0) {
                count = (count + oddCount) % MOD;
                evenCount++;
            } else {
                count = (count + evenCount) % MOD;
                oddCount++;
            }
        }
        return count;
    }
}