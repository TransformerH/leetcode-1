/**
 * Build one stack,
 * 1, every time when a push operation is called, if larget than min, just push it in;
 * 2, if push(x) <= min value, push the previous min, then set x as min, and push x.
 * this step is like a back up to always push the 2nd min value below the real min value 
 * 3, when we do pop(), pop first and compare it with the min value, if they are the same
 * pop again to fetch the NEW min value and assign it to MIN.
 */
 
class MinStack {
    
    Stack<Integer> stack;
    int min = Integer.MAX_VALUE;
    
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int x) {
        if (x <= min){
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }
    
    public void pop() {
        if (stack.pop() == min) min = stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */