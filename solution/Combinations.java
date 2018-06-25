class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        // if (n == 1) return res;
        helper(res, new ArrayList(), n, k, 1);
        return res;
    }
    public void helper(List<List<Integer>> res, List<Integer> temp, int n, int k, int start){
        if (temp.size() == k){
            res.add(new ArrayList(temp));
            return;
        }
        for (int i = start; i <= n; i++){
            // if (!temp.contains(i)) temp.add(i);
            temp.add(i);
            helper(res, temp, n, k, i+1);
            temp.remove(temp.size() - 1);
        }
    }
}
