/**
in bit representation, if the LSB of n is 0, remove it

>>> shift right doesnt preseve the sign(MSB)
>> preserves the sign
 */
class Solution {
    public int integerReplacement(int n) {
        int count = 0;
        while (n != 1){
            if ((n & 1) == 0)
                n >>>= 1;
            else if (n == 3 || Integer.bitCount(n - 1) < Integer.bitCount(n + 1))
                n -= 1;
            else 
                n += 1;
            count++;
        }
        return count;
    }
}