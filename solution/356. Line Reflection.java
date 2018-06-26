import java.util.HashSet;
import java.util.Set;

/**
 * Assume there is this line which is parallel to y-axis, for the points to be reflected by this line,
 * two of them have to form a pair, which share the same y value and the sum of X values should be the 
 * same for each pairs
 * 
 * could also use hashtable, where x axis as key and y axis as value
 */
class Solution {
    public boolean isReflected(int[][] points) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        Set<String> set = new HashSet<>();
        for (int[] point : points){
            max = Math.max(max, point[0]);
            min = Math.min(min, point[0]);
            set.add(point[0] + "" + point[1]);
        }
        int constant = max + min;
        for (int[] point : points){
            if (!set.contains((constant - point[0]) + "" + point[1]))
                return false;
        }
        return true;
    }
}