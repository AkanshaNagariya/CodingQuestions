class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        char[] a = s.toCharArray();
        int n = a.length;
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            if (a[i] == '(') {
                // Only append if it's not an outermost parenthesis
                if (count > 0) {
                    ans.append('(');
                }
                count++;  // Track the balance
            } else {
                count--;  // Closing parenthesis
                // Only append if it's not an outermost parenthesis
                if (count > 0) {
                    ans.append(')');
                }
            }
        }
        
        return ans.toString();
    }
}
