class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        helper(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }
    public void helper(List<List<Integer>> res, List<Integer> temp, int[] candidates, int target, int start){
        if (target < 0) return;
        else if (target == 0){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < candidates.length; i++){
            temp.add(candidates[i]);
            helper(res, temp, candidates, target - candidates[i], i);
            temp.remove(temp.size()-1);
        }
    }
}
