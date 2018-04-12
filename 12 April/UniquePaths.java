class Solution {
    public int uniquePaths(int m, int n) {
        int[][] sol = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (i == 0 || j == 0){
                    sol[i][j] = 1;
                }
                else{
                    sol[i][j] = sol[i-1][j] + sol[i][j-1];
                }
            }
        }
        return sol[m-1][n-1];
    }
}
