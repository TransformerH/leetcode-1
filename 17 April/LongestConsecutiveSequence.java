class Solution {
    public int longestConsecutive(int[] nums) {
       if (nums.length == 0 || nums == null) return 0;
        Arrays.sort(nums);
        int res = 0;
        int temp = 1;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] - nums[i-1] == 1)
                temp++;
            else if (nums[i] == nums[i-1]){
                continue;
            }else
                temp = 1;
            res = Math.max(res,temp);
        }
        return Math.max(temp, res);
    }
}
