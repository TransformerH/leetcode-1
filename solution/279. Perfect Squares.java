class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++){
            dp[i] = i;
        }
        for (int i = 1; i <= n; i++){
            if (i * i <= n) dp[i*i] = 1;
            for (int j = 0; i + j * j <= n; j++){
                dp[i+j*j] = Math.min(dp[i+j*j], dp[i] + 1);
            }
        }
        return dp[n];
    }
}