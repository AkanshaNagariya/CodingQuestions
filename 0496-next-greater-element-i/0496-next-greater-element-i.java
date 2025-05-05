class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int [] nge = new int[nums1.length];
        Stack<Integer> st = new Stack<>();
        HashMap<Integer,Integer> map =  new HashMap<>();
        for(int i= 0; i<nums2.length;i++){
            while(!st.isEmpty() && st.peek() < nums2[i]){
                map.put(st.pop(),nums2[i]);
            }
            st.push(nums2[i]);
        }
        for(int i: st){
            map.put(i,-1);
        }
        for(int i=0; i<nums1.length;i++){
            nge[i] = map.get(nums1[i]);
        }
        return nge;
    }
}