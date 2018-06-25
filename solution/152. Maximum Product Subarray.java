/**
    use a max and a min to keep track of the max product and min product:
    e.g., max = 6, min = -8, nums[i] = -2 => min * nums[i] will be the new max
    then use res to keep track of the max product till now;

 */
class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0 || nums == null) return 0;
        int res = nums[0], max = nums[0], min = nums[0];
        for (int i = 1; i < nums.length; i++){
            int temp = max;
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);
            if (max > res)
                res = max;
        }
        return res;
    }
}