class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        for (int num : nums) {
            if (num % 2 == 0) {
                mp.put(num, mp.getOrDefault(num, 0) + 1);
            }
        }
            int maxFreq = 0;
        int ans = -1;

        // Iterate through the map to find the most frequent even number
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            int key = entry.getKey();
            int freq = entry.getValue();

            if (freq > maxFreq || (freq == maxFreq && key < ans)) {
                maxFreq = freq;
                ans = key;
            }
        }

        return ans;
    }
}