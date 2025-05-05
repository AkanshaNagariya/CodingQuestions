class Solution {
    public String clearDigits(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                 if(!st.isEmpty()){
                st.pop();
            }
            }
           else {
            st.push(ch);
           }
        }
        while(!st.isEmpty()){
            ans.insert(0, st.pop());
        }
        return ans.toString();
    }
}