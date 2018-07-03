/**
self-crossing situations:
1. 4th crosses with 1st or 5th with 2nd or 6th with 3rd and so on...
2. 5th with 1st ...
3. 6th with 1st ...
*/

/**
 
        2
    3       1
        4
 */

class Solution {
    public boolean isSelfCrossing(int[] x) {
        int len = x.length;
        if (len <= 3) return false;
        for (int i = 0; i < len - 3; i++){
            if (x[i] >= x[i + 2] && x[i + 1] <= x[i + 3]) return true;
            if (i < len - 4){
                //5th line with 1st line
                if (x[i + 1] == x[i+3] && x[i + 2] - x[i + 4] <= x[i]) return true;
            }
            if (i < len - 5 ){
                // 6th line with 1st line
                if (x[i + 3] >= x[i + 1] && x[i + 2] - x[i + 4] <= x[i] && x[i+5] >= x[i+3] - x[i+1] && x[i+2] >= x[i+4] ) return true;
            }
        }
        return false;
    }
}