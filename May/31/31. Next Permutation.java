class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length == 0 || nums == null) return;

        int firstSmall = -1;
        for (int i = nums.length - 2; i >=0; i--){
            if (nums[i] < nums[i+1]){
                firstSmall = i;
                break;
            }
        }
        if (firstSmall == -1){
            // nums is in descending order
            // reverve the whole nums
            reverse(nums, 0, nums.length - 1);
            return;
        }
        int firstLarge = -1;
        for (int i = nums.length - 1; i > firstSmall; i--){
            if (nums[i] > nums[firstSmall]){
                firstLarge = i;
                break;
            }
        }
        swap(nums, firstSmall, firstLarge);
        reverse(nums, firstSmall+1, nums.length - 1);
        return;
    }
    public void reverse(int[] nums, int start, int end){
        while (start < end){
            swap(nums, start++, end--);
        }
    }
    public void swap(int[] nums, int start, int end){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}
