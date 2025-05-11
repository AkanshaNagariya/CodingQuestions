class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int cnt = 3;
        for(int i=0; i<arr.length;i++){
            if(arr[i] % 2 != 0){
                cnt--;
                if(cnt == 0){
                    return true;
                }
            } else {
                cnt = 3;
            }
        }
        return false;
    }
}