
class Solution {
    public int[] sortEvenOdd(int[] nums) {
        // Separate even-indexed and odd-indexed elements
        int n = nums.length;
        int evenCount = (n + 1) / 2;
        int oddCount = n / 2;

        int[] even = new int[evenCount];
        int[] odd = new int[oddCount];

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) even[i / 2] = nums[i];
            else odd[i / 2] = nums[i];
        }

        // Sort even-indexed values in ascending order
        Arrays.sort(even);

        // Sort odd-indexed values in descending order
        Arrays.sort(odd);
        for (int i = 0; i < odd.length / 2; i++) {
            int temp = odd[i];
            odd[i] = odd[odd.length - 1 - i];
            odd[odd.length - 1 - i] = temp;
        }

        // Merge them back
        for (int i = 0, e = 0, o = 0; i < n; i++) {
            if (i % 2 == 0) nums[i] = even[e++];
            else nums[i] = odd[o++];
        }

        return nums;
    }
}