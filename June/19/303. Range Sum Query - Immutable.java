class NumArray {
/**
 * O(n) init
 * O(1) query which is good cause  there are "many calls to sumRange function"
 */
    int[] res;
    public NumArray(int[] nums) {
        res = nums;
        for (int i = 1; i < res.length; i++){
            res[i] += res[i-1];
        }
    }
    
    public int sumRange(int i, int j) {
        if (i == 0)
            return res[j];
        return res[j] - res[i-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */