class Solution {
    public int mostWordsFound(String[] sentences) {
        int max = 0;
        for(String str : sentences){
            int len =  str.split(" ").length;
            max = Math.max(max,len);
        }
        return max;
    }
}