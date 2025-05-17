class Solution {
    public int minEatingSpeed(int[] piles, int h) {
       int start = 1; 
       int end = findmax(piles);
       int ans  = Integer.MIN_VALUE;
       while(start <= end){
        int k  = start + (end - start)/2;
        int sumhours = findhours(piles , k);
        if(sumhours <= h){
            ans = k;
            end = k-1;
        } 
         else {
            start = k+1;
        }
       }
       return ans;
    }
    static int findhours(int [] piles , int k){
        int hours = 0;
        for(int i=0; i<piles.length;i++){
             hours += Math.ceil((double)(piles[i]) /(double)(k));
        }
        return hours;
    }
    static int findmax(int [] piles){
       int max = Integer.MIN_VALUE;
       for(int i=0; i<piles.length;i++){
           max = Math.max(max, piles[i]);
       }
       return max;
    }
}