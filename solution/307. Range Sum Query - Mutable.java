class NumArray {

    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
        for (int i = 1; i < nums.length; i++){
            nums[i] += nums[i - 1];
        }
    }
    
    public void update(int i, int val) {
        if (i == 0) nums[i] = val;
        else{
            int temp = nums[i-1];
            
        }
    }
    
    public int sumRange(int i, int j) {
        if (i == 0) return nums[j];
        else return nums[j] - nums[i - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */