class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target)
                return true;
            if (nums[mid] == nums[left] && nums[mid] == nums[right]){
                left++;
                right--;
            }else if (nums[mid] >= nums[left]){ // first half in order
                if (nums[left] <= target && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }else if (nums[mid] < nums[left]){ // second half in order
                if (nums[mid] < target && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return false;
    }
}
