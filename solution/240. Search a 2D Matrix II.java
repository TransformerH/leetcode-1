class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // use matrix[matrix.length - 1][matrix[0].length - 1] as a ref
        // if ref == target, return true;
        // if ref < target, row++
        // if ref > target, col--
        if (matrix.length == 0 || matrix == null || matrix[0].length == 0 || matrix[0] == null) return false;
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0){
            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] > target) col--;
            else row++;
        }
        return false;
    }
}
