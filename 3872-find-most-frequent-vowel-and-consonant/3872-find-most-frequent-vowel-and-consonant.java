class Solution {
    public int maxFreqSum(String s) {
       HashMap<Character, Integer> mp = new HashMap<>();
       int vow = 0, con = 0;
       for(char ch : s.toCharArray()){
        mp.put(ch, mp.getOrDefault(ch,0)+1);
       }
       for (Map.Entry<Character, Integer> entry : mp.entrySet()) {
        char c = entry.getKey();
        int val = entry.getValue();
        if(c == 'a' || c == 'e' || c == 'i' || c== 'o' || c == 'u'){
            vow = Math.max(vow, val);
        } else{
            con = Math.max(con, val);
        }
       }
        return vow+con;
    }
}