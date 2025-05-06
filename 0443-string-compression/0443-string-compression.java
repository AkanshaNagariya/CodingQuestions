class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int index = 0; // Tracks the position to insert compressed characters

        for (int i = 0; i < n; ) {
            char ch = chars[i];
            int cnt = 0;

            // Count occurrences of the character
            while (i < n && chars[i] == ch) {
                cnt++;
                i++;
            }

            // Store the character
            chars[index] = ch;
            index++;

            // Store count if greater than 1
            if (cnt > 1) {
                String str = String.valueOf(cnt);
                for (char c : str.toCharArray()) {
                    chars[index] = c;
                    index++;
                }
            }
        }
        return index; // Return the new length of compressed chars array
    }
}
