class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }
        return padList("", digits);
    }

    static ArrayList<String> padList(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        int digit = up.charAt(0) - '0';
        // Mapping letters based on the digit
        String[] mapping = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };

        ArrayList<String> ans = new ArrayList<>();
        String letters = mapping[digit];

        for (char ch : letters.toCharArray()) {
            ans.addAll(padList(p + ch, up.substring(1)));
        }
        return ans;
    }
}
