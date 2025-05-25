class Solution {
    public String resultingString(String s) {
    Stack<Character> st = new Stack<>();
    for (char ch: s.toCharArray()) {
        if (!st.isEmpty() && checkcons(st.peek(),ch)) {
            st.pop();
            } 
        else {
            st.push(ch);
            }
        }
    StringBuilder str = new StringBuilder();
        for(char ch : st) {
        str.append(ch);
        }
        return str.toString();
    }
    private boolean checkcons(char i, char j) {
        int p = Math.abs(i-j);
        return p== 1 || p == 25;
    }
}