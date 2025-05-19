class Solution {
    public int minSwaps(int[] nums) {
        int len = nums.length;
        
        int [][] arrsum = new int[len][2];
        for(int j=0; j<len; j++){
            arrsum[j][0] = nums[j];
            
            arrsum[j][1] = countsum(nums[j]);
        }
        Arrays.sort(arrsum, (a,b)-> {
          if(a[1] != b[1]) return Integer.compare(a[1],b[1]);
        return Integer.compare(a[0],b[0]);
        });
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int j=0; j<len; j++){
            mp.put(arrsum[j][0],j);
        }
        boolean [] found = new boolean[len];
        int swaps = 0;
        
        for(int j=0; j<len; j++){
            if(found[j] || mp.get(nums[j]) == j) continue;
                int cylen = 0;
            int curr = j;
            
            while(!found[curr]){
                found[curr] = true;
                curr = mp.get(nums[curr]);
                cylen++;
            }
            if(cylen>1){
                swaps += (cylen-1);
            }
        }
        return swaps;
    }
    public static int countsum(int digit) {
        int res = 0;
        while(digit>0){
            res += digit % 10;
            digit /= 10;
        }
        return res;
    }
}