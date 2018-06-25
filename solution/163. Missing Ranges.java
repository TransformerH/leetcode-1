import java.util.ArrayList;

/**
 * 1. overflow --> use LONG????
 */
class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        long alower = (long) lower, aupper = (long) upper;
        for (int num : nums){  
            if (num == alower)
                alower++;
            else if (num > alower){
                if (num - 1 == alower)
                    res.add(alower + "");
                else
                    res.add(alower + "->" + (num - 1));
                alower = (long) (num + 1);
            }
            // WHY could this solve overflow???
            if (num == Integer.MAX_VALUE) return res;
        }
        if (alower == aupper)
            res.add(alower + "");
        else if (alower < aupper)
            res.add(alower + "->" + aupper);      
        return res;
    }
}