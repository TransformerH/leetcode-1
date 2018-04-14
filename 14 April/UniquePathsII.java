class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] sol = new int[m][n];
        for (int i = 0; i < m; i++){
            if (obstacleGrid[i][0] == 1) {
                for (int k = i; k < m; k++)
                    sol[k][0] = 0;
                break;
            }
            else sol[i][0] = 1;
        }
        for (int j = 0; j < n; j++){
            if (obstacleGrid[0][j] == 1){
                for (int l = j; l < m; l++)
                    sol[0][j] = 0;
                break;
            }
            else sol[0][j] = 1;
        }
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                if (obstacleGrid[i][j] == 1)
                    sol[i][j] = 0;
                else
                    sol[i][j] = sol[i-1][j] + sol[i][j-1];
            }
        }
        return sol[m-1][n-1];

    }
}
