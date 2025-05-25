class Solution {
    public long minCuttingCost(int n, int m, int k) {
    long cuts = 0;
         if (n > k) {
            cuts +=  (long) (n - k) * k;
        }
         if (m > k) {
            cuts += (long) (m - k) * k;
        }
         return cuts;
    }
}