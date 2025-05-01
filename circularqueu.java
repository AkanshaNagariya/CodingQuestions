#circular Queue
public class circularqueu {
    static class Queue {
        static int arr[];
        static int size;
        static int rear = -1;
        static int front = -1;
        Queue(int n){
            arr = new int[n];
            this.size = n;
        }
        public static boolean isEmpty(){
            return rear == -1 && front == -1;
        }
        public static boolean isFull(){
            return (rear+1) % size == front;
        }
        // add 
        public static void enqueue (int data){
            if(isFull()){
                System.out.println("queue is full");
                return;
            }
            if(front == -1){ // when 1st element is enqueue
                front = 0;
            } 
            rear = (rear+1) % size;
            arr[rear] = data;
        }

        public static int dequeue() {
            if(isEmpty()){
                System.out.println("empty queue");
                return -1;
            }
            int result = arr[front];
            if(rear == front){ // single element in queue
                rear = front = -1;
            } else {
                front = (front + 1) % size;
            }
            return result;
        }
        public static int peek(){
            if(isEmpty()){
                System.out.println("empty queue");
                return -1;
            }
            return arr[front]; // peek value
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue (5); // circular Queue using array  , we added 7 elements in 5 size array with dequeue
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3); // 1 2 3 enqueue hua
        q.enqueue(4);
        q.enqueue(5); 
        System.out.println(q.dequeue()); // prints 1
        q.enqueue(6);  
        System.out.println(q.dequeue()); // prints 2
        q.enqueue(7);
        while(!q.isEmpty()){
            System.out.println(q.peek()); // front at 3 so prints 3 after dequeue in down front 4 so prints 4 , prints 3 to 7
            q.dequeue();
        }
    }
}

