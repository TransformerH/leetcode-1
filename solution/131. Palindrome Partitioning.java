class Solution {
    public List<List<String>> partition(String s) {
        //dp??
        List<List<String>> res = new ArrayList<>();
        if (s.length() == 0 || s == null) return res;
        helper(s, res, new ArrayList<String>(), 0);
        return res;
    }
    public void helper(String s, List<List<String>> res, List<String> tempList, int start){
        //return condition
        if (tempList.size() > 0 && start >= s.length()){
            res.add(new ArrayList<String>(tempList));
            return;
        }
        //backtracking
        for (int i = start; i < s.length(); i++){
            if (isPalindrome(s, start, i)){
                tempList.add(s.substring(start, i+1));
                helper(s, res, tempList, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
    public boolean isPalindrome(String s, int start, int end){
        while (start < end){
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

}
