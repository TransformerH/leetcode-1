class Solution {
    public List<List<Integer>> getFactors(int n) {
        /**
         * base case: n == 1, if there are more than 1 elements, that's the solution
         * every time divide n by number from 2 to n (recursively?)
         */
        // Use backtrack to find all combinations
        List<List<Integer>> res = new ArrayList<>();
        helper(n, res, new ArrayList<>(), 2);
        return res;
    }
    private void helper(int n, List<List<Integer>> res, List<Integer> temp, int index){
        if (n == 0 || n == 1){
            if (temp.size() >= 2){
                res.add(new ArrayList<>(temp));
            }
            return;
        }
        for (int i = index; i <= n; i++){
            if (n % i == 0){
                temp.add(i);
                helper(n/i, res, temp, i);
                temp.remove(temp.size() - 1);
            }
        }
    }
}