class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i<words.length; i++){
            String sub = words[i];
            if (sub.indexOf(x) != -1) {
                ans.add(i);
            }
        }
        return ans;
    }
}