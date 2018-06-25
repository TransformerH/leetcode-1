import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 1, 2, 3, 3, 3
 * when it scans the first '3', random.nextInt(1) will definitely be 0, so res becomes 2
 * 
 * when it scans the second '3', randome.nextInt(2) will be 50% 0 and 50% 1
 * 50% when the random int is 0, res will be 3
 * 50% when the random int is 1, res will still be 2
 * 
 * when it scans the third '3', randome.nextInt(3) will be 33% 0 and 33% 1 and 33% 2
 * 33% when the random int is 0, res will be 4
 * 33% when the random int is 1 or 2, res will stay being 3/2 with 50% of the chance each
 * 
 */
class Solution {

    private int[] nums;
    private Random random;
    public Solution(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    } 
    public int pick(int target) {
        int count = 0;
        int res = -1;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == target){
                if (random.nextInt(++count) == 0)
                    res = i;
            }
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */