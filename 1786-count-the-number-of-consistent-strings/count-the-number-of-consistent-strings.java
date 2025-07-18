class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        HashSet<Character> sh = new HashSet<>();
        for(int i=0; i< allowed.length();i++){
            sh.add(allowed.charAt(i));
        }
        int count = 0;
        for(String k:words){
            int flag = 1; 
            for(int i=0; i<k.length();i++){
                if(!sh.contains(k.charAt(i))){
                    flag =  0;
                    break;
                }
            }
            count += flag;
        }
        return count;
    }
}