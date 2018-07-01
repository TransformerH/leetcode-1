class Solution {
    // there could be + - * or space between EACH digit
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) return res;
        helper(res, "", num, target, 0, 0, 0);
        return res;
    }
    private void helper(List<String> res, String temp, String num, int target, int pos, long eval, long mult){
        if (pos == num.length() && eval == target){
            res.add(temp);
            return;
        }
        for (int i = pos; i < num.length(); i++){
            //  两个数字组合的时候，不能以0开头
            if (i != pos && num.charAt(pos) == '0') continue;
            
            long cur = Long.parseLong(num.substring(pos, i + 1));
            
            if (pos == 0){
                helper(res, temp + cur, num, target, i + 1, eval + cur, cur);
            }else{
                helper(res, temp + "+" + cur, num, target, i + 1, eval + cur, cur);
                helper(res, temp + "-" + cur, num, target, i + 1, eval - cur, -cur);
                helper(res, temp + "*" + cur, num, target, i + 1, eval - mult + mult * cur, mult * cur);
            }
            
        }
    }
}