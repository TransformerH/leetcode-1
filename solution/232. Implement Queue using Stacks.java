class MyQueue {
    Stack<Integer> queue;
    Stack<Integer> temp;
    /** Initialize your data structure here. */
    public MyQueue() {
        queue = new Stack();
        temp = new Stack();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!queue.isEmpty()){
            temp.push(queue.pop());
        }
        queue.push(x);
        while (!temp.isEmpty()){
            queue.push(temp.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return queue.pop();
    }

    /** Get the front element. */
    public int peek() {
        return queue.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return queue.size() == 0;
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
