class Solution {
    public long subArrayRanges(int[] nums) {
        return sumSubarrayMax(nums)-sumSubarrayMins(nums);
    }
    public long sumSubarrayMins(int[] arr) {
        int [] nse  = findNse(arr);
        int [] pse = findPse(arr);
        long total = 0;
        for(int i=0; i<arr.length;i++){
            int left = i - pse[i];
            int right = nse[i] - i;
            long product = (long) right * left * arr[i];
             total = total + product;
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
     public long sumSubarrayMax(int[] arr) {
        int [] nge  = findNge(arr);
        int [] pge = findPge(arr);
        long total = 0;
        for(int i=0; i<arr.length;i++){
            int left = i - pge[i];
            int right = nge[i] - i;
            long product = (long) right * left * arr[i];
             total = total + product;
        }
        return total;
    }
     static int [] findNge(int [] arr){
        int n = arr.length;
        int [] nge = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = n-1; i>=0; i--){
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nge[i] = n;
            } else {
                nge[i] = st.peek();
            }
            st.push(i);
        }
        return nge;
    }
    static int [] findPge(int [] arr){
        int n = arr.length;
        int [] pge = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<n; i++){
            while(!st.isEmpty() && arr[st.peek()] < arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                pge[i] = -1;
            } else {
                pge[i] = st.peek();
            }
            st.push(i);
        }
        return pge;
    }
}