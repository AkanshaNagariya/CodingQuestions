class Solution {
    public int sumSubarrayMins(int[] arr) {
        int [] nse  = findNse(arr);
        int [] pse = findPse(arr);
        int total = 0;
        int modval = (int)(1000000000 + 7);
        for(int i=0; i<arr.length;i++){
            int left = i - pse[i];
            int right = nse[i] - i;
            long product = (long) right * left * arr[i];
             total = (int) ((total + product % modval) % modval);
        }
        return total;
    }
    static int [] findNse(int [] arr){
        int n = arr.length;
        int [] nse = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = n-1; i>=0; i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nse[i] = n;
            } else {
                nse[i] = st.peek();
            }
            st.push(i);
        }
        return nse;
    }
    static int [] findPse(int [] arr){
        int n = arr.length;
        int [] pse = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<n; i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                pse[i] = -1;
            } else {
                pse[i] = st.peek();
            }
            st.push(i);
        }
        return pse;
    }
}