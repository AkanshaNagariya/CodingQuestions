class Solution {
    public int maximumSum(int[] nums) {
        int arr[] = new int[nums.length];
        Map<Integer, Integer> map = new HashMap<>();
        int finalans = -1;

        for (int i = 0; i < nums.length; i++) {
            int s = digitsum(nums[i]);
            arr[i] = s;

            if (map.containsKey(s)) {
                finalans = Math.max(finalans, map.get(s) + nums[i]);
                map.put(s, Math.max(map.get(s), nums[i])); // Store the max number for this digit sum
            } else {
                map.put(s, nums[i]);
            }
        }

        return finalans;
    }
    static int digitsum(int n){
        int ans = 0;
        while(n>0){
            int rem = n % 10;
            ans = ans + rem;
            n = n/10;
        }
        return ans;
    }
}