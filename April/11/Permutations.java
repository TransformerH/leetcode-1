class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0 || nums == null) return res;
        helper(res, new ArrayList<>(), nums);
        return res;
    }
    public void helper(List<List<Integer>> res, List<Integer> temp, int[] nums){
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            // return;
        }
        for (int i = 0; i < nums.length; i++){
            if (temp.contains(nums[i])) continue;
            temp.add(nums[i]);
            helper(res, temp, nums);
            temp.remove(temp.size() - 1);
        }
    }
}
