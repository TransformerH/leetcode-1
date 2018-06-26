/**
 * bottom-up DP
 * 
 * 1. state: [left][right]: 
 * the MAX coins if we burst all the baloons in between left and right (exclusive)
 * 
 * 2. result:
 * add '1' to the front and end of the array and let new length be n
 * then return [0][n-1]
 * 
 * 3. initial:
 * 0
 * 
 * 4. function:
 * let i be a baloon from left + 1 to right - 1, assume i is the last among those 
 * to be bursted:
 * dp[left][right] = coins[i] * coins[left] * coins[right]
 *                  + dp[left][i]
 *                  + dp[i][right]
 * take the max value of dp[left][right] when i is from left + 1 to right - 1
 * 
 * 5. pre-processing:
 * if there is a 0, burst it first as it won't add any coins to the final result
 */

class Solution {
    public int maxCoins(int[] nums) {
        if (nums.length == 0 || nums == null) return 0;
        int[] arr = new int[nums.length + 2];
        int n = 0;
        arr[n++] = 1;
        for (int num : nums){
            if (num > 0)
                arr[n++] = num;
        }
        arr[n++] = 1;
        int[][] dp = new int[n][n];
        for (int dis = 2; dis < n; dis++){
            for (int left = 0; left + dis < n; left++){
                int right = left + dis;
                for (int i = left + 1; i < right; i++)
                    dp[left][right] = Math.max(dp[left][right], arr[i] * arr[left] * arr[right] + dp[left][i] + dp[i][right]);
            }
        }
        return dp[0][n-1];
    }
}