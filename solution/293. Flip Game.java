class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() == 0 || s.length() == 1) return res;
        for (int i = 0; i < s.length() - 1; i++){
            if (s.charAt(i) == '+' && s.charAt(i+1) == '+'){
                s = s.substring(0, i) + "--" + s.substring(i+2);
                res.add(temp);
                s = s.substring(0, i) + "++" + s.substring(i+2);
            }
        }
        return res;
    }
}