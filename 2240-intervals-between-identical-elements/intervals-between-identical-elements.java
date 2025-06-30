class Solution {
    public long[] getDistances(int[] arr) {
        int n = arr.length;
        long[] res = new long[n];
        Map<Integer, List<Integer>> map = new HashMap<>();

        // Group indices by value
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], x -> new ArrayList<>()).add(i);
        }

        // For each group, do two passes
        for (List<Integer> indices : map.values()) {
            int size = indices.size();

            // Left to right pass
            long total = 0, count = 0;
            for (int i = 0; i < size; i++) {
                int idx = indices.get(i);
                res[idx] += (long) idx * count - total;
                total += idx;
                count++;
            }

            // Right to left pass
            total = 0;
            count = 0;
            for (int i = size - 1; i >= 0; i--) {
                int idx = indices.get(i);
                res[idx] += total - (long) idx * count;
                total += idx;
                count++;
            }
        }

        return res;
    }
}