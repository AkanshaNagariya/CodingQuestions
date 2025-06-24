class Solution {
    public String defangIPaddr(String address) {
        String ans = "";
        for(char ch : address.toCharArray()){
            if(ch == '.'){
                ans = ans + '[' + '.' +']';
            } else {
                ans = ans + ch;
            }
        }
        return ans;
    }
}