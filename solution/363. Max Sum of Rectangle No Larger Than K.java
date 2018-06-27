import java.util.TreeSet;

/**
 * time O(n * n * m * log(m))
 * => O(col * col * row * log(row))
 * space O(row)
 * 
 * take away points:
 * 1. for 1D array, use Kadane algo to find the max sum of its subarray
 * def (A[]):
 *  max_cur, max_global = A[0]
 *  for i = 1 to A.length - 1:
 *      max_cur = max(A[i], A[i] + max_cur) // max_cur denotes the max sum ending at ith item
 *      max_global = max(max_global, max_cur)
 *  return max_global
 */

class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int res = Integer.MIN_VALUE;
        for (int l = 0; l < n; l++){
            int[] sum = new int[m];
            for (int r = l; r < n; r++){
                for (int i = 0; i < m; i++)
                    sum[i] +=matrix[i][r];
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                int temp = 0;
                for (int i : sum){
                    temp += i;
                    Integer gap = set.ceiling(temp - k);
                    if (gap != null) res = Math.max(res, temp - gap);
                    set.add(temp);
                }
            }
        }
        return res;
    }
}