class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer , Integer> map = new HashMap<>();
        int [] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            int need = target - num;
            if(map.containsKey(need)){
                ans[0] = i;
                ans[1] = map.get(need);
                return ans;
            }
            map.put(nums[i], i);
        }
        return ans;
    }

}