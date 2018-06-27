/**
 * Q: What if there are lots of merges and the number of disjoint intervals are small compared to the data stream's size?
 * A: TreeMap is log(n) time for basic operations
 * 
 * Use a TreeMap data structure to implement:
 * 
 * KEY is the start(smallest) value in the interval 
 * while VALUE is the Interval
 * 
 * TreeMap maintains an acesding order compared to HashMap
 */

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }    
 */
class SummaryRanges {

    private TreeMap<Integer, Interval> tree;
    /** Initialize your data structure here. */
    public SummaryRanges() {
        tree = new TreeMap<>();
    }
    public void addNum(int val) {
        if (tree.containsKey(val)) return;
        Integer low = tree.lowerKey(val);
        Integer high = tree.higherKey(val);
        if (low != null && high != null && tree.get(low).end + 1 == val && high - 1 == val){
            tree.get(low).end = tree.get(high).end;
            tree.remove(high);    
        }else if (low != null && tree.get(low).end + 1 >= val)
            tree.get(low).end = Math.max(val, tree.get(low).end);
        else if (high != null && high - 1 == val){
            tree.put(val, new Interval(val, tree.get(high).end));
            tree.remove(high);
        }    
        else
            tree.put(val, new Interval(val, val));
    }
    public List<Interval> getIntervals() {
        return new ArrayList<>(tree.values());
    }
}


/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */