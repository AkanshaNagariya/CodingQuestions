class MinStack {
    Stack<Integer> st;
     Stack<Integer> mins;
    public MinStack() {
        st = new Stack<>();
        mins = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(mins.isEmpty() || val <= mins.peek()){
            mins.push(val);
        }
    }
    
    public void pop() {
        if(!st.isEmpty()){
            if(st.peek().equals(mins.peek())){
                mins.pop();
            }
             st.pop();
        }
    }
    
    public int top() {
       int x =  st.peek();
       return x;
    }
    
    public int getMin() {
        return mins.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */