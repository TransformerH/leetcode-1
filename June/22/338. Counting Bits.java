/**
 * this is a typical DP problem
 * f(n) =  f(n / 2) + n % 2
 */
class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        res[0] = 0;
        
        for (int i = 0; i <= num; i++){
            res[i] = res[i >> 1] + i % 2;
        }
        return res;
    }
}