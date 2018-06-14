/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

 /**
  *  first sort the array as per start time
  *  then compare start time with the end time of the previous meeting
  */
class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b){
                return a.start - b.start;
            }
        });
        for (int i = 1; i < intervals.length; i++){
            if (intervals[i].start < intervals[i-1].end)
                return false;
        }
        return true;
    }
    public boolean canAttendMeetings2(Interval[] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 1; i < intervals.length; i++){
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        for (int i = 1; i < intervals.length; i++){
            if (starts[i] < ends[i-1])
                return false;
        }
        return true;
    }
}