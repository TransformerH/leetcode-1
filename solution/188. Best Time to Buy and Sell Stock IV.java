/**
 * dp[i][j]: at most i transactions until jth day
 * 
 * state trasition:
 * dp[i][j] = max( dp[i][j-1], dp[i-1][m] + price[j] - price[m])
 *          = max(dp[i][j-1], price[j] + max(dp[i-1][m] - price[m]))
 * base case:
 * dp[0][j] = 0 (0 transactions cannot make profit)
 * dp[i][0] = 0 (day 1 cannot make any profit)
 */

// if k > days/2, it means that we can transact on any day, 
//  as long as it adds to a position profit

class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n <= 1) return 0;
        if (k >= n/2) return heloper(prices);// special case
        int[][] dp = new int[k + 1][n];
	    for (int i = 1; i <= k ; i++){
            int temp = dp[i-1][0] - prices[0];
            for (int j = 1; j < n; j++){
                dp[i][j] = Math.max(dp[i][j-1], prices[j] + temp);
                temp = Math.max(temp, dp[i-1][j] - prices[j]);
            }
        }
        return dp[k][n-1];
    }
    private int helper(int[] prices){
        int ret = 0;
        for (int i = 1; i < prices.length; i++){
            if (prices[i] > prices[i-1])
                ret += prices[i] - prices[i-1];
        }
        return ret;
    }
}