import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
/**
 * The distance is calculated using Manhattan Distance, where distance(p1, p2) 
 * = |p2.x - p1.x| + |p2.y - p1.y|.
 * 
 * min distance would be min x-axis distance + min y-axis distance among all the points 
 * where the vaue is 1
 * 
 * the min distance among 1, 2, 3, 4, 5, 6, 7 is (7-1) + (6-2) + (5 - 3) = 12 
 */
class Solution {
    public int minTotalDistance(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0 || grid == null || grid[0] == null) return 0;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1){
                    list1.add(i);
                }
            }
        }
        for (int i = 0; i < grid[0].length; i++){
            for (int j = 0; j < grid.length; j++){
                if (grid[j][i] == 1){
                    list2.add(i);
                }
            }
        }
        return findMinDistance(list1) + findMinDistance(list2);
    }
    private int findMinDistance(List<Integer> list){
        int i = 0;
        int j = list.size() - 1;
        int sum = 0;
        while (i < j){
            sum += j - i;
            j--;
            i++;
        }
        return sum;
    }
}