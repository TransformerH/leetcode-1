class Solution {
    public int combinationSum4(int[] nums, int target) {
        // sol 1: recursive
        if (target == 0) 
            return 1;// here the target == 0 refers to target - nums[i] == 0, which means the ith number itself could reach the target
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            if (target >= nums[i])
                sum += combinationSum4(nums, target - nums[i]);
        }
        return sum;
    }
}

class Solution {
    // top-down
    // time O(mn) where m is target and n is nums length
    public int combinationSum4(int[] nums, int target) {
        // since sol 1 calculates the same results for too many times, it won't pass the OJ
        // when target is too large
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return helper(dp, nums, target);
    }
    private int helper(int[] dp, int[] nums, int target){
        if (dp[target] != -1)
            return dp[target];
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            if (target >= nums[i])
                sum += helper(dp, nums, target - nums[i]);
        }
        dp[target] = sum;
        return sum;
    }
}

class Solution {
    // bottom up
    //time O(mn) where m is target and n is nums length
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++){
            for (int j = 0; j < nums.length; j++){
                if (i >= nums[j])
                    dp[i] += dp[i-nums[j]];
            }
        }
        return dp[target];
    }
}