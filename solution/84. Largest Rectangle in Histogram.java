/**
 * use a stack to store all the indices in ascending order
 * when the cur index becomes smaller, start calculating the previous areas
 * 
 * time O(N)
 * space O(N)
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int i = 0;
        int max = 0;
        while (i <= n) {
            int cur = i == n? 0 : heights[i];
            if (stack.isEmpty() || cur > heights[stack.peek()])
                stack.push(i++);
            else{
                int temp = stack.pop();
                max = Math.max(max, heights[temp] * (stack.isEmpty() ? i : (i - stack.peek() - 1)));
            }
        }
        return max;
    }
}