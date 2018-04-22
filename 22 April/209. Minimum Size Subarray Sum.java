class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        //[2,3,1,2,4,3]
        // two pointer algo??
        // firstly i and j points to the first item
        // continue adding nums[i] until the sum >= s
        // while (sum >= s)
        //   keep subtracting the jth value from sum and keep a record of min length

        if (nums.length == 0 || nums == null) return 0;
        int sum = 0, j = 0;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            while (sum >= s){
                res = Math.min(res, i - j + 1);
                sum -= nums[j++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
