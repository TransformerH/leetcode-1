class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n == 0 && k == 0) return res;
        helper(res, new ArrayList<>(), 1, n, k);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> temp, int index, int n, int k){
        if (temp.size() > k || n < 0)
            return;
        else if (n == 0 && k == temp.size()){
            res.add(new ArrayList<>(temp));
            return;
        }
        if (n < 0 || temp.size() > k || (n > 0 && temp.size() == k))
            return;
        for (int i = index; i <= 9; i++){
            temp.add(i);
            helper(res, temp, i + 1, n - i, k);
            temp.remove(temp.size() - 1);
        }
    }
}
