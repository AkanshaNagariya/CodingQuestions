class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = Integer.MIN_VALUE;
        int arraysum = 0;
        for(int i=0; i<weights.length;i++){
            max = Math.max(max, weights[i]);
            arraysum += weights[i];
        }
        int low = max; int high = arraysum; int ans = 0;
        while(low <= high){
            int mid = low + (high - low) /2;
            if(findcapacity(weights, mid) <= days){
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }
    static int findcapacity(int weights[] , int mid){
        int sum = 0; int noofdays = 1;
        for(int i=0; i<weights.length; i++){
            sum += weights[i];
            if(sum > mid){
                noofdays++;
                sum = weights[i];
            }
        }
        return noofdays;
    }
}