// time O(N)
// space O(1)
class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length <= 2) return false;
        int firstNum = Integer.MAX_VALUE, secondNum = Integer.MAX_VALUE;
        for (int num : nums){
            if (num <= firstNum)
                firstNum = num;
            else if (num <= secondNum)
                secondNum = num;
            else
                return true;//when the program reaches here, it means that we will always have an int
                // which is LARGER the firstNum or secondNum

        }
        return false;
    }
}