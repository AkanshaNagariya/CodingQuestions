class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.equals(s2)) return true;
        List<Integer> idxes = new ArrayList<>();
        for(int i=0; i<s1.length();i++){
            if(s1.charAt(i) != s2.charAt(i)){
                idxes.add(i);
            }
        }
        if(idxes.size() != 2) return false;
        int i = idxes.get(0);
        int j = idxes.get(1);
        return s1.charAt(i) == s2.charAt(j) && s1.charAt(j) == s2.charAt(i);
    }
}