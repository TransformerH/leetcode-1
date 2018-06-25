class Solution {
    // a 2 and a 5 countribute to 10, which adds a trailing zero when we talk about factorial
    // for any n like 20, the # of mupliple of 2 is way larger than the # of mupliple of 5:
    // 2: 2, 4, 6, 8, 10, 12, 14...
    // 5: 5, 10, 15
    // so to calculate 10 we just have to calculate 5;
    public int trailingZeroes(int n) {
        int count = 0;
        while (n >= 5){
            n /= 5;
            count += n;
        }
        return count;
    }

    public int trailingZeroes2(int n) {
        return n == 0 ? n : n / 5 + trailingZeroes(n / 5);
    }
}
