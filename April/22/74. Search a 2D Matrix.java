class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix == null || matrix[0].length == 0 || matrix[0] == null) return false;
        int x = matrix.length;
        int y = matrix[0].length;
        int left = 0, right = x * y - 1;
        while (left < right){
            int mid = (right - left) / 2 + left;
            if (matrix[mid/y][mid%y] == target)
                return true;
            else if (matrix[mid/y][mid%y] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return matrix[left/y][left%y] == target ? true : false;
    }
}
