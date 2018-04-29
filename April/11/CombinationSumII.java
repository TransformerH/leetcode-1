class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        if (candidates == null || candidates.length == 0 ) return res;
        helper(res,new ArrayList<>(), candidates,target,0);

        return res;
    }
    public void helper(List<List<Integer>> res, List<Integer> temp, int[] candidates, int target, int start ){
        if (target < 0) return;
        else if (target == 0){
            if (res.contains(temp)) return;
            else {
                res.add(new ArrayList<>(temp));
                return;
            }
        }else{
            for (int i = start; i < candidates.length; i++){
                temp.add(candidates[i]);
                helper(res, temp, candidates, target-candidates[i], i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
}
