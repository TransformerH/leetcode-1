class Solution {
    public String[] map = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        helper(res, digits, new String(), 0);
        return res;
    }
    public void helper(List<String> res, String digits, String temp, int index){
        if (index == digits.length()){
            res.add(temp);
            return;
        }
        String dummy = map[digits.charAt(index) - '0']; // "23", 2: abc
        for (int i = 0; i < dummy.length(); i++){
            temp += dummy.charAt(i);
            helper(res, digits, temp, index+1);
            temp = temp.substring(0,temp.length()-1);
        }
    }
}
