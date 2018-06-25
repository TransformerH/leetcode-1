/**
 * use a Queue to place all the newly incoming values 
 * also maintain a int to count how many values have been placed into Queue
 * once it reaches the limit, remove the head item
 * at the same time update the SUM properly
 */
class MovingAverage {

    Queue<Integer> queue;
    int maxSize;
    double sum;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        queue = new LinkedList<>();
        maxSize = size;
        sum = 0;
    }
    
    public double next(int val) {
        if (queue.size() >= maxSize){
            sum -= queue.remove();
        }
        queue.offer(val);
        sum += val;
        return sum / queue.size();
        //
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */