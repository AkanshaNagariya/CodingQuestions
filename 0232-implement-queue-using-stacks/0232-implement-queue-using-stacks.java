import java.util.Stack;
class MyQueue {
        Stack<Integer> objj;
        Stack<Integer> st;
    public MyQueue() {
        objj = new Stack<>();
        st = new Stack<>();
    }
    
    public void push(int x) {
        objj.push(x);
    }
    
    public int pop() {
        while(!objj.isEmpty()){
            st.push(objj.pop());
        }
        int removed  = st.pop();
        while(!st.isEmpty()){
            objj.push(st.pop());
        }
        return removed;
    }
    
    public int peek() {
        while(!objj.isEmpty()){
            st.push(objj.pop());
        }
        int peeked  = st.peek();
        while (!st.isEmpty()) {
        objj.push(st.pop());
    }
        return peeked;
    }
    
    public boolean empty() {
        return objj.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */