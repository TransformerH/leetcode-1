class Solution {
    public void setZeroes(int[][] matrix) {
        //[0,0,0],
        //[0,0,0],
        //[1,0,1]
        // if 0, pass to the beginning of its col and row
        // if first row/col = 0, set a flag
        //
        //
        if (matrix.length == 0 || matrix == null || matrix[0] == null || matrix[0].length == 0) return;

        int m = matrix.length, n = matrix[0].length;
        boolean col = false, row = false;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (matrix[i][j] == 0){
                    if (i == 0) row = true;
                    if (j == 0) col = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                if (matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }else if (matrix[i][0] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if (col){
            for (int i = 0; i < m; i++){
                matrix[i][0] = 0;
            }
        }
        if (row){
            for (int i = 0; i < n; i++){
                matrix[0][i] = 0;
            }
        }

    }
}
