class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(1, 0, ans, new ArrayList<>(), k, n);
        return ans;
    }

    public void helper(int num, int sum, List<List<Integer>> ans, ArrayList<Integer> curr, int k, int n) {
        // Valid combination
        if (k == 0 && sum == n) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        // Prune invalid paths
        if (num > 9 || sum > n || k == 0) return;

        // Include current number
        curr.add(num);
        helper(num + 1, sum + num, ans, curr, k - 1, n);
        curr.remove(curr.size() - 1); // backtrack

        // Exclude current number
        helper(num + 1, sum, ans, curr, k, n);
    }
}