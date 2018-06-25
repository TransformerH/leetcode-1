class Solution {
    /**
     * 思路：
     * 1.每个cell试一遍，向四个方向搜更小的数字
     * 2.如果有更小的，就继续搜；如果没有，就停止和return
     * 3.记录每个cell最长的path数，以防止重复计算
     * 
     * 4.用一个2d的cache存储已经有结果的cell，这样下次visit找个cell就不用重复计算
     */
    public int longestIncreasingPath1(int[][] matrix) {
        if (matrix.length == 0 || matrix == null) return 0;
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int temp = helper(matrix, i, j, Integer.MIN_VALUE);
                res = Math.max(temp, res);
            }
        }
        return res;
    }
    private int helper(int[][] matrix, int i, int j, int prev) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] <= prev) return 0;
        int tempMax = 0;
        int temp = matrix[i][j];
        tempMax = Math.max(helper(matrix, i + 1, j, temp), tempMax);
        tempMax = Math.max(helper(matrix, i - 1, j, temp), tempMax);
        tempMax = Math.max(helper(matrix, i, j + 1, temp), tempMax);
        tempMax = Math.max(helper(matrix, i, j - 1, temp), tempMax);
        tempMax++;
        return tempMax;
    }

    public int longestIncreasingPath2(int[][] matrix) {
        if (matrix.length == 0 || matrix == null) return 0;
        int res = 0;
        int[][] cache = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int temp = helper2(matrix, i, j, Integer.MIN_VALUE, cache);
                res = Math.max(temp, res);
            }
        }
        return res;
    }
    private int helper2(int[][] matrix, int i, int j, int prev, int[][] cache) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] <= prev) return 0;
        if (cache[i][j] > 0){
            return cache[i][j];
        }else{
            int tempMax = 0;
            int temp = matrix[i][j];
            tempMax = Math.max(helper2(matrix, i + 1, j, temp, cache), tempMax);
            tempMax = Math.max(helper2(matrix, i - 1, j, temp, cache), tempMax);
            tempMax = Math.max(helper2(matrix, i, j + 1, temp, cache), tempMax);
            tempMax = Math.max(helper2(matrix, i, j - 1, temp, cache), tempMax);
            cache[i][j] = ++empMax;
            // ++i 和 i++的区别
            return tempMax;
        }
    }
}