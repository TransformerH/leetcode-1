class Solution {
    public boolean isPerfectSquare(int num) {
        // declare the mid as long to avoid overflow
        int low = 1;
        int high = num;
        while (low <= high){
            long mid = (high - low)/2 + low;
            if (mid * mid == num)
                return true;
            else if (mid * mid < num)
                low = (int) mid + 1;
            else 
                high = (int) mid - 1;
        }
        return false;
    }
}