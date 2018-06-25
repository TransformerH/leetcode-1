class Solution {
    public boolean canJump(int[] nums) {
        // use MAX to represent the maxium position it could reach from its current position
        // Time: O(n)
        // Space: O(1)
        int max = 0;
        for (int i = 0; i < nums.length; i++){
            if (i > max) return false;
            max = Math.max(i + nums[i], max);
        }
        return true;
    }
}
