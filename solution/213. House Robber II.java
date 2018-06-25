class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        return Math.max(helper(nums, 0, nums.length - 2), helper(nums, 1, nums.length - 1));
    }
    public int helper(int[] nums, int low, int high){
        int currYes = 0, currNo = 0;
        int prevYes = 0, prevNo = 0;
        for (int i = low; i <= high; i++){

            currYes = prevNo + nums[i];
            currNo = Math.max(prevYes, prevNo);
            prevNo = currNo;
            prevYes = currYes;
        }
        return Math.max(currYes, currNo);
    }
}
