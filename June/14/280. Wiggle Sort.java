class Solution {
    public void wiggleSort(int[] nums) {
        //reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
        // [3,5,2,1,6,4]
        // [3,5,1,6,2,4]
        // 也就是说基数位的都大于前面的
        //偶数位的都小于前面的（除了第一个）
        //  5 10 2 7 3
        for (int i = 0; i < nums.length; i++){
            if (i % 2 == 1){
                if (nums[i] < nums[i-1])
                    swap(nums, i);
            }else{
                if (i!= 0 && nums[i] > nums[i-1])
                    swap(nums, i);
            }
        }
    }
    private void swap(int[] nums, int index){
        int temp = nums[index];
        nums[index] = nums[index - 1];
        nums[index - 1] = temp;
    }
}