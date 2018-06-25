class Solution {
    public int divide(int dividend, int divisor) {
        // 1. +/-
        // 2. overflow
        // 3. equals to 0
        // 4. divisor = 0 no need to be covered as Java would throw exception.
        int sign = 1;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0))
            sign = -1;
        long dividendL = Math.abs((long)dividend);
        long divisorL = Math.abs((long)divisor);
        if (dividendL < divisorL || dividendL == 0) return 0;
        long res = helper(dividendL, divisorL);
        if (res > Integer.MAX_VALUE){
            return (sign == -1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }else
            return (int)(sign * res);
    }
    public long helper(long dividend, long divisor){
        if (dividend < divisor) return 0;
        long sum = divisor;
        long res = 1;
        while (sum + sum <= dividend){
            sum += sum;
            res += res;
        }
        return res + helper(dividend - sum, divisor);
    }
}
