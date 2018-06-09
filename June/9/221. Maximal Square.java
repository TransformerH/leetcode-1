class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix == null) return 0;
        int res = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if (i == 0 || j == 0){
                    if (matrix[i][j] == '0')
                        dp[i][j] = 0;
                    else
                        dp[i][j] = 1;
                }
                else if (matrix[i][j] == '1')
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i-1][j-1]), dp[i][j-1]) + 1;
                res = Math.max(res, dp[i][j]);
            }
        }
        return res * res;
    }
}
