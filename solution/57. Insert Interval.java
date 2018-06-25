/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int start = newInterval.start, end = newInterval.end;
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0){
            res.add(newInterval);
            return res;
        }
        int i = 0;
        while (i < intervals.size() && intervals.get(i).end < newInterval.start){
            res.add(intervals.get(i));
            i++;
        }
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end){
            newInterval = new Interval(Math.min(intervals.get(i).start, newInterval.start), Math.max(intervals.get(i).end, newInterval.end));
            i++;
        }
        res.add(newInterval);
        while (i < intervals.size()){
            res.add(intervals.get(i++));
        }
        return res;
    }
}
