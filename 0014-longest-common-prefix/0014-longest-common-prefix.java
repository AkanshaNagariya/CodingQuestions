class Solution {
    public String longestCommonPrefix(String[] strs) {
      Arrays.sort(strs);
      StringBuilder sb = new StringBuilder();
      char [] a = strs[0].toCharArray();
      char [] b = strs[strs.length -1].toCharArray();
      int n = Math.min(a.length,b.length);
      for(int i=0; i<n;i++){
        if(a[i] != b[i]) break;
            sb.append(a[i]);
      }
      return sb.toString();
    }
}