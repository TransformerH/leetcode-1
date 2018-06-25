/**
 * Use two PriorityQueue to maintain the large half and the smaller half
 * if they have the same size, means the total number is even
 * else, the total number is odd
 */
class MedianFinder {

    private PriorityQueue<Integer> large;
    private PriorityQueue<Integer> small;
    /** initialize your data structure here. */
    public MedianFinder() {
        large = new PriorityQueue<>();
        small = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        // maintain large and small so that 
        // either large has one more item or they are the same

        large.add(num);
        small.add(-large.poll());
        if (large.size() < small.size()){
            large.add(-small.poll());
        }

    }
    
    public double findMedian() {
        return large.size() == small.size() ? (large.peek() - small.peek())/2.0 : large.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */