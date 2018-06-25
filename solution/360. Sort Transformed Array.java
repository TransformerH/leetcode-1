/**
Given a sorted array of integers nums and integer values a, b and c. 
Apply a quadratic function of the form f(x) = ax2 + bx + c to each element x in the array.
The returned array must be in sorted order.

thought process:
according to maths, if the arrays is sorted from negative to positive(in ascending order)
when a > 0, the two sides must be bigger than the middle
when a < 0, the middle must be bigger than the two sides

so we just need to use a merge sort like process to process the orders
 */

class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int[] res = new int[n];
        int i = 0, j = n - 1;
        int start = a >= 0 ? n - 1 : 0;
        while (i <= j){
            if (a >= 0){
                res[start--] = helper(nums[j], a, b, c) > helper(nums[i], a, b, c) ? helper(nums[j--], a, b, c) : helper(nums[i++], a, b, c);
            }else{
                res[start++] = helper(nums[j], a, b, c) > helper(nums[i], a, b, c) ? helper(nums[i++], a, b, c) : helper(nums[j--], a, b, c);
            }   
        }
        return res;
    }
    private int helper(int x, int a, int b, int c){
        return x * x * a + x * b + c;
    }
}