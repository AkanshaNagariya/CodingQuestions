class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int low = 1; 
        int high = position[n-1] - position[0];
        while(low <= high){
            int mid = low + (high-low)/2;
            if(placed(position, mid , m) == true){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return high;
     }
     static boolean placed(int [] position, int mid, int m){
        int placed = 1 ; int last = position[0];
        for(int i=1; i<position.length; i++){
            if(position[i] - last >= mid){
                placed++;
                last = position[i];
            }
        }
        if(placed >= m) return true;
        return false;
     }
}