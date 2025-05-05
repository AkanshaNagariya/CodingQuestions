class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int  i=0; i<asteroids.length; i++){
            if(asteroids[i] > 0){
                st.push(asteroids[i]);
            } else {
                while(!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(asteroids[i])){
                    st.pop();
                }
                if(!st.isEmpty() && st.peek() == Math.abs(asteroids[i])){
                    st.pop();
                }
                else if(st.isEmpty() || st.peek() < 0){
                    st.push(asteroids[i]);
                }
            }
        }
        int n = st.size();
        int ans [] = new int[n];
        for(int j = n-1; j>=0 ;j--){
            ans[j] = st.peek();
            st.pop();
        }
        return ans;
    }
}