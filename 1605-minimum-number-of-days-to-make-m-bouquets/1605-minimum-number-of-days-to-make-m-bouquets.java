class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(m * k > bloomDay.length){
            return -1;
        }
        int start = findmin(bloomDay);
        int end = findmax(bloomDay);
        int ans = -1;
        while(start <= end){
            int midday = start + (end - start)/2;
            int bouquet = findpossible(bloomDay, midday , m , k);
            if(bouquet == 1){
                ans = midday;
                end = midday-1;
            } else {
                start = midday+1;
            }
        }
        return ans;
    }
    static int findmin(int [] bloomDay){
       int min = Integer.MAX_VALUE;
       for(int i=0; i<bloomDay.length;i++){
           min = Math.min(min, bloomDay[i]);
       }
       return min;
    }
    static int findmax(int [] bloomDay){
       int max = Integer.MIN_VALUE;
       for(int i=0; i<bloomDay.length;i++){
           max = Math.max(max, bloomDay[i]);
       }
       return max;
    }
    static int findpossible(int [] bloomDay , int midday , int m , int k){
        int cnt = 0; int noofBouq = 0;
        for(int i=0; i<bloomDay.length;i++){
            if(bloomDay[i] <= midday){
                cnt++;
            } else {
                noofBouq += (cnt/k);
                cnt = 0;
            }
        }
        noofBouq += (cnt / k);
        if(noofBouq >= m) return 1;
        return 0;
    }
}