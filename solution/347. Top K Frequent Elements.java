import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * sol 1 : maxHeap(Priority Queue)
 * 1. count occurances of all nums and put it into a map  (int -> count)
 * 2. put this map into a maxHeap
 * 3. take top k values from maxHeap and return
 * 
 *  worst case time O(NlogN)
 *
 * default V getOrDefault(Object key, V defaultValue)
Returns the value to which the specified key is mapped, or defaultValue if this map contains no mapping for the key.

sol2: linear time
 */
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(
            (a, b) -> (b.getValue() - a.getValue())
        );
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            queue.add(entry);
        }
        List<Integer> res = new ArrayList<>();
        while (res.size() < k){
            res.add(queue.poll().getKey());
        }
        return res;
    }
}