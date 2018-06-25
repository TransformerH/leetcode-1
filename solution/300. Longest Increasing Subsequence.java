class Solution {
    public int lengthOfLIS(int[] nums) {
        /**
         * solution 1:
         * time O(N^2)
         * space O(N)
         */
        if (nums.length == 0 || nums == null) return 0;
        int[] dp = new int[nums.length + 1];
        int max = 1;
        for (int i = 0; i < nums.length; i++)
            dp[i] = 1;
        for (int i = 1; i < nums.length; i++){
            for (int j = 0; j < i; j++){
                if (nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(dp[i], max);
                }
            }
        }
        return max;
    }
    public int lengthOfLIS2(int[] nums) {
        /**
         * time O(n*logn)
         */
    }
}