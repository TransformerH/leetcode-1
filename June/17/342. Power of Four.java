class Solution {
    /**
     * what if iterative and recursive is not allowed?
     */
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num == 1 || num % 4 == 0 && isPowerOfFour(num / 4));
    }
    public boolean isPowerOfFour2(int num) {
        if (num <= 0) return false;
        while(num % 4 == 0){
            num /= 4;
        }
        return num == 1;
    }
}