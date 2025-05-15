class Solution {
    public boolean closeStrings(String word1, String word2) {
         if (word1.length() != word2.length()) {
            return false;
        }

        int freq1[] = new int[26]; 
        int freq2[] = new int[26];
        
        for (int i = 0; i < word1.length(); i++) {
            char ch = word1.charAt(i);
            freq1[ch - 'a']++;
        }

        for (int i = 0; i < word2.length(); i++) {
            char ch = word2.charAt(i);
            freq2[ch - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (freq2[i] != 0 && freq1[i] == 0 || freq1[i] != 0 && freq2[i] == 0) {
                return false;
            }
        }

        Arrays.sort(freq1);
        Arrays.sort(freq2);

        for (int i = 0; i < 26; i++) {
            if (freq2[i] != freq1[i]) {
                return false;
            }
        }

        return true;
    }
}