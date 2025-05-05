class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        List<String> res = allStrings(n);
        List<String> numlist = Arrays.asList(nums);
        for(int i=0; i<res.size(); i++){
            if(numlist.contains(res.get(i))){
                continue;
            } else {
               return res.get(i);
            }
        }
        return "";
    }
    public static List<String> allStrings(int n){
        ArrayList<String> ans = new ArrayList<>();
        generate(n, "", ans);
        return ans;
    }
    public static void generate(int n, String s , ArrayList<String> ans){
        if(s.length() == n){
            ans.add(s);
            return;
        }
        generate(n, s + "0", ans);
        generate(n, s + "1", ans);
    }
}