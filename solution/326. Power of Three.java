class Solution {
    /**
     * There are several solutions: 
     * 1. recursive
     * 2. iterative
     * 3. what if 1 and 2 are NOT allowed?
     */
    public boolean isPowerOfThree(int num) {
        return n > 0 && (n == 1 || n % 3 == 0 && isPowerOfThree(n/3));
    }

    public boolean isPowerOfThree2(int num) {
        if ( num <= 0) return false;
        while ( num % 3 == 0){
            num /= 3;
        }
        return num == 1;
    }
}