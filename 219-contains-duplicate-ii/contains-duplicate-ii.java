class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
         Map<Integer, Integer> check = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (check.containsKey(val) && i - check.get(val) <= k) {
                return true;
            }
            check.put(val, i);
        }

        return false;      
    }
}