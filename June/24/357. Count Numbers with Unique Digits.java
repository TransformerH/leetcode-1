class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int[] dp = new int[11];
        dp[1] = 10;
        dp[2] = 9 * 9;
        int j = 8;
        for (int i = 3; i <= 10  && j > 0; i++){
            dp[i] = dp[i - 1] * j--;
        }
        int res = 0;
        for (int i = 1; i <= n; i++){
            if (i > 10) break; // longer than 10 digits will definitely be 0
            res += dp[i];
        }
        return res;
    }
}