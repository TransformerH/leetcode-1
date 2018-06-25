public class Solution {
    public int mySqrt(int x) {
        if (x == 0) return x;
        int start = 1, end = x;
        while (start <= end){
            long mid = (end - start) / 2 + start;
            if (mid * mid == x)
                return (int)mid;
            else if (mid * mid < x) {
                start = (int)mid + 1;
            }else
                end = (int)mid - 1;
        }
        return end*end < x ? (int)end : (int)start;
    }
}
