class Solution {
    public int countDigits(int num) {
        int org = num;
        int cnt = 0;
        while(org > 0){
            int rem = org % 10;
            if(num % rem == 0){
                cnt++;
            }
            org = org / 10;
        }
        return cnt;
    }
}