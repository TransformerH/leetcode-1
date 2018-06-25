class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        if (n == 0) return null;
        int rowStart = 0, rowEnd = n-1;
        int colStart = 0, colEnd = n-1;
        int counter = 1;
        while (rowStart <= rowEnd && colStart <= colEnd){
            for (int i = colStart; i <= colEnd; i++){
                res[rowStart][i] = counter;
                counter++;
            }
            rowStart++;
            for (int i = rowStart; i <= rowEnd; i++){
                res[i][colEnd] = counter;
                counter++;
            }
            colEnd--;
            if (rowStart <= rowEnd){
                for (int i = colEnd; i >=colStart; i--){
                    res[rowEnd][i] = counter;
                    counter++;
                }
            }
            rowEnd--;
            if (colStart <= colEnd){
                for (int i = rowEnd; i >= rowStart; i--){
                    res[i][colStart] = counter;
                    counter++;
                }
            }
            colStart++;
        }
        return res;
    }
}
