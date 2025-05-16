class Solution {
    public int addDigits(int num) {
        if(num / 10 == 0)
            return num;
        else
            // Recursively reduce by summing digits
            return addDigits(add(num));
    }

    public static int add(int num){
        // Base case: last digit
        if(num / 10 == 0)
            return num;
        // Sum current digit and recurse
        return num % 10 + add(num / 10);
    }
}