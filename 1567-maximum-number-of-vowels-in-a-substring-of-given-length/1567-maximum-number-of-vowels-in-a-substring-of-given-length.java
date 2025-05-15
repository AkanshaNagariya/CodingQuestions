class Solution {
    public int maxVowels(String s, int k) {
        int res = 0;
        int cnt = 0;
        
        for(int i=0; i<k; i++){
            if(checkVowel(s.charAt(i))){
                cnt++;
            }
        }
        res = Math.max(res,cnt);
        for(int i=k; i<s.length();i++){
            if(checkVowel(s.charAt(i))){
                cnt++;
            }
            if(checkVowel(s.charAt(i-k))){
                cnt--;
            }
            res = Math.max(res,cnt);
        }
        return res;
    }
    private boolean checkVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c=='u';
    }
}