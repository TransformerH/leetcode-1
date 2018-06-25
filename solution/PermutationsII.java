class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0 || nums == null) return res;
        helper(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }
    public void helper(List<List<Integer>> res, List<Integer> temp, int[] nums, boolean[] used){
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
        }
        for (int i = 0; i < nums.length; i++){
            if (used[i] || i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
            used[i] = true;
            temp.add(nums[i]);
            helper(res, temp, nums, used);
            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }
}
