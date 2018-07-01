/**
Given N axis-aligned rectangles where N > 0, 
determine if they all together form an exact cover of a rectangular region.

Each rectangle is represented as a bottom-left point and a top-right point. 
For example, a unit square is represented as [1,1,2,2]. (coordinate of 
bottom-left point is (1, 1) and top-right point is (2, 2)).

THUS, 
1. all rectangles total area should be the same as the final rec area
2. # of final 4 points should be 1 for each; and that of the rest should be even
*/

class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles.length == 0 || rectangles == null) return false;
        int x1 = Integer.MAX_VALUE,
            x2 = Integer.MIN_VALUE,
            y1 = Integer.MAX_VALUE,
            y2 = Integer.MIN_VALUE;
        int area = 0;
        Set<String> set = new HashSet<>();
        for (int[] rec : rectangles){
            area += (rec[2] - rec[0]) * (rec[3] - rec[1]);

            x1 = Math.min(x1, rec[0]);
            y1 = Math.min(y1, rec[1]);
            x2 = Math.max(x2, rec[2]);
            y2 = Math.max(y2, rec[3]);

            if (!set.add(rec[0] + "" + rec[1])) set.remove(rec[0] + "" + rec[1]);
            if (!set.add(rec[0] + "" + rec[3])) set.remove(rec[0] + "" + rec[3]);
            if (!set.add(rec[2] + "" + rec[1])) set.remove(rec[2] + "" + rec[1]);
            if (!set.add(rec[2] + "" + rec[3])) set.remove(rec[2] + "" + rec[3]);
        }
        if (set.size() != 4) return false;
        if (!set.contains(x1 + "" + y1) || !set.contains(x1 + "" + y2) || !set.contains(x2 + "" + y1) || !set.contains(x2 + "" + y2)) return false;
        
        return area == (x2 - x1) * (y2 - y1);
    }
}