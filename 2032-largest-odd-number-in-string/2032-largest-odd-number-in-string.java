class Solution {
    public String largestOddNumber(String num) {
       for(int i = num.length(); i>=0; i--){
        if(i != 0 && num.charAt(i-1)%2 != 0){
            return num.substring(0,i);
        } 
         if(i ==0){
            if(i % 2 != 0){
                return num.substring(0,1);
            }
         }
        }
        return "";
    }
}