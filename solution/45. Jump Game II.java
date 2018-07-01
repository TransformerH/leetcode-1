class Solution {
    public int jump(int[] nums) {
        // like bfs, loop each time to measure how farest it could reach
        // if it could reach the last node, return
        // other wise, move next step
        if (nums.length < 2) return 0;
        int low = 0, 
            high = 0;
        for (int i = 0; i < nums.length; i++){
            int farthest = 0;
            for (int j = low; j <= high; j++){      
                farthest = Math.max(farthest, nums[j] + j);
                if (farthest >= nums.length - 1) return i + 1;
            }
            low = high + 1;
            high = farthest;
        }
        return -1;
    }
}