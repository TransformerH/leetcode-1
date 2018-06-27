/**
 * a bulb is on iff it is switched an odd number of times (1st time on, 2nd time off, only 3rd, 5th... will be on)
 * 
 * the ith bulb will be switched at k rounds only if k divides i
 * 
 * 1 and 2 divides 2;
 * 1,2,3,6 divides 6;
 * 1, 2, 4 divides 4;
 * 
 * so a bulb ends up being on iff it is a square
 * 
 * e.g. for the 4th bulb, it will be switched off during 2nd round and will then be switched
 * on during 4th round
*/


class Solution {
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }
}