class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        // bitwise AND on a range of numbers
        int count = 0;
        while (m != n){
            m >>= 1;
            n >>= 1;
            count++;
        }
        return m <<= count;
    }
}
