import java.util.LinkedList;
import java.util.Queue;

/**
 * Use a queue to record all the hits  (add their timestamps into the queue)
 * 
 * when getHits is called, pop out all those beyond 5 mins, the rest size
 * of the queue is the # of hits
 */
class HitCounter {
    
    private Queue<Integer> queue;
    /** Initialize your data structure here. */
    public HitCounter() {
        queue = new LinkedList<>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        queue.offer(timestamp);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while (!queue.isEmpty() && timestamp - queue.peek() >= 300) 
                queue.poll();
        return queue.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */