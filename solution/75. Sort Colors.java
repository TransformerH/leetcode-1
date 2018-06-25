class Solution {
    public void sortColors(int[] nums) {
        if (nums.length == 0 || nums == null) return;
        int j = 0;
        int left = 0, right = nums.length - 1;
        int index = 0;
        while (index <= right){
            if (nums[index] == 0)
                // left - 1 refers to the last 0
                swap(nums, left++, index++);
            else if (nums[index] == 1)
                index++;
            else
                // right+1 refers to the first 2
                swap(nums, index, right--);
        }
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
