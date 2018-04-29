class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) return res;
        helper(res, new String(), n, 0, 0);
        return res;
    }
    private void helper(List<String> res, String temp, int n, int left, int right){
        if (temp.length() == n*2){
            res.add(temp);
            return;
        }
        if (left < n){
            helper(res, temp + '(', n, left+1, right);
        }
        if (right < left){
            helper(res, temp + ')', n, left, right+1);
        }
    }
}
