class Solution {
    public String reverseVowels(String s) {
        char ans[] = new char[s.length()];
        int idx = 0;
        int i = 0;
        int n = s.length();
        
        // Step 1: Store vowels
        while (i < n) {
            char ch = s.charAt(i);
            if (isVowel(ch)) {
                ans[idx++] = ch;
            }
            i++; // ✅ Fix: Increment `i` always
        }

        // Step 2: Reverse stored vowels
        for (int t = 0; t < idx / 2; t++) {
            char temp = ans[idx - t - 1];
            ans[idx - t - 1] = ans[t];
            ans[t] = temp;
        }

        // Step 3: Replace vowels in original string
        StringBuilder fin = new StringBuilder(s);
        int j = 0, k = 0;
        while (j < n) {
            char ch = s.charAt(j);
            if (isVowel(ch)) {
                fin.setCharAt(j, ans[k++]);
            }
            j++;
        }

        return fin.toString();
    }

    // Helper function to check vowels
    private boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) != -1;
    }
}
