// if n is next to the max integer, then having missed + missed > n would cause overflow
// thus missed must be long type
class Solution {
    public int minPatches(int[] nums, int n) {
        long missed = 1;
        int i = 0;
        int res = 0;
        while (missed <= n){
            if (i < nums.length && nums[i] <= missed)
                missed += nums[i++];
            else{
                missed += missed;
                res++;
            }
        }
        return res;
    }
}