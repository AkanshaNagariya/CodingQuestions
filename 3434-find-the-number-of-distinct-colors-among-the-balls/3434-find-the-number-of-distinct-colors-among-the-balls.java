import java.util.*;

class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> colorFrequency = new HashMap<>(); // Tracks occurrences of each color
        int ans[] = new int[queries.length];
        int distinctColors = 0;

        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0];
            int y = queries[i][1];

            // If x already has a color, decrease its frequency
            if (map.containsKey(x)) {
                int oldColor = map.get(x);
                
                // Reduce frequency of the old color
                colorFrequency.put(oldColor, colorFrequency.get(oldColor) - 1);
                
                // If no more balls have this color, remove it
                if (colorFrequency.get(oldColor) == 0) {
                    colorFrequency.remove(oldColor);
                    distinctColors--; // Reduce count of distinct colors
                }
            }

            // Update x with new color
            map.put(x, y);

            // Increase frequency of the new color
            colorFrequency.put(y, colorFrequency.getOrDefault(y, 0) + 1);

            // If it's a new color, increase distinct color count
            if (colorFrequency.get(y) == 1) {
                distinctColors++;
            }

            // Store current distinct color count
            ans[i] = distinctColors;
        }
        return ans;
    }
}
