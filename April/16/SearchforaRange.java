class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0 || nums == null) return new int[]{-1,-1};
        int[] sol = new int[2];
        sol[0] = findFirst(nums, target);
        if (sol[0] == -1) return new int[]{-1,-1};
        sol[1] = findLast(nums, target);
        return sol;
    }
    public int findFirst(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while (left < right){
            int mid = (left+right)/2;
            if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }
        if (nums[left] == target) return left;
        return -1;
    }
    public int findLast(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while (left < right){
            int mid = (left+right)/2 + 1;
            if (nums[mid] > target)
                right = mid - 1;
            else
                left = mid;
        }
        if (nums[right] == target) return right;
        return -1;
    }
}
