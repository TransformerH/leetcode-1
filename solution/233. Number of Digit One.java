class Solution {
    public int countDigitOne(int n) {
        int cnt = 0;
        for (long i = 1; i <= n; i *= 10){
            long r = n / i;
            long m = n % i;
            cnt += (r + 8) / 10 * i + (r % 10 == 1 ? (m + 1): 0);
        }
        return cnt;
    }
}