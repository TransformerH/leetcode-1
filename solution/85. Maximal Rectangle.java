/**
 * scan each row and calculate its max rectangle
 * (each row adds up together would be like histogram)
 * 
 * time O(row * col * col)
 * space ? O(col * col)
 */
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = m > 0 ? matrix[0].length : 0;
        if (m * n == 0) return 0;
        int[] res = new int[n];
        int max = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (matrix[i][j] == '1')
                    res[j]++;
                else
                    res[j] = 0;
            }
            max = Math.max(max, helper(res));
        }
        return max;
    }
    private int helper(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int i = 0;
        int max = 0;
        while (i <= n){
            int cur = i == n ? 0 : heights[i];
            if (stack.isEmpty() || cur > heights[stack.peek()])
                stack.push(i++);
            else {
                int temp = stack.pop();
                max = Math.max(max, heights[temp] * (stack.isEmpty() ? i : (i - 1 - stack.peek())));
            }
        }
        return max;
    }
}