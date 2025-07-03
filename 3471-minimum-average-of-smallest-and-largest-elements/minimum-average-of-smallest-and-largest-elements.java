class Solution {
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        double arr [] = new double[n/2];
        for(int i=0; i<arr.length;i++){
            arr[i] = (nums[i]+nums[n - i- 1])/2.0;
        }
        Arrays.sort(arr);
        return arr[0];
    } 
}