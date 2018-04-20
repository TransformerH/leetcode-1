class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            // when there's no rotation:
            if (nums[left] < nums[right])
                return nums[left];

            //corner case: where there're only two items
            int mid = (right + left) / 2;
            if (nums[mid] >= nums[left])
                left = mid + 1;
            else
                right = mid;
        }
        return nums[left];
    }
}
