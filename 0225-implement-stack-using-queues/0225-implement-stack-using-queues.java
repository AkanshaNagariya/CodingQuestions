import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    Queue<Integer> objj;
    Queue<Integer> st;

    public MyStack() {
        objj = new LinkedList<>();
        st = new LinkedList<>();
    }

    public void push(int x) {
        objj.add(x); // Add element to the main queue
    }

    public int pop() {
        // Move all elements except the last one to the secondary queue
        while (objj.size() > 1) {
            st.add(objj.remove());
        }
        int removed = objj.remove(); // Get the last element (stack's top)
        
        // Swap the queues to preserve stack behavior
        Queue<Integer> temp = objj;
        objj = st;
        st = temp;

        return removed;
    }

    public int top() {
        // Move all elements except the last one to the secondary queue
        while (objj.size() > 1) {
            st.add(objj.remove());
        }
        int peeked = objj.remove(); // Get the last element (stack's top)
        st.add(peeked); // Add it back to the secondary queue

        // Swap the queues to preserve stack behavior
        Queue<Integer> temp = objj;
        objj = st;
        st = temp;

        return peeked;
    }

    public boolean empty() {
        return objj.isEmpty();
    }
}
