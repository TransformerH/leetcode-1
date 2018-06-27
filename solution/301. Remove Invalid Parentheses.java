/**
 * steps:
 * 1. count how many unpaired right bracket and left bracket in total;
 * 2. dfs, delete ')' then '('
 * 3. when r == 0 && l == 0, check if the new string is valid, if yes, add to res
 * 4. continue dfs
 * 
 * 5. in order to avoid using hashset for duplications,
 *  when there are two or more (( or )), just aim for the first one and skip the rest
 * 
 * time O(2^(l+r))
 * space O( (l+r) ^2 ) ~ O(n^2)
 */
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        // step1 check if string is valid
        int l = 0, r = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '(')
                l++;
            if (l == 0 && s.charAt(i) == ')')
                r++;
            else if (l != 0 && s.charAt(i) == ')')
                l--;
        }
        dfs(s, 0, l, r, res);
        return res;
    }
    private void dfs(String s, int index, int l, int r, List<String> res){
        if (l == 0 && r == 0 && isValid(s)){
            res.add(s);           
            return;
        }
        for (int i = index; i < s.length(); i++){
            if (i != index && s.charAt(i) == s.charAt(i - 1)) continue;
            
            if (s.charAt(i) == '(' || s.charAt(i) == ')'){
                String temp = s.substring(0, i) + s.substring(i+1);
                if (r > 0) dfs(temp, i, l, r - 1, res);
                else if (l > 0) dfs(temp, i, l - 1, r, res);
            }
        }
    }
    // check if the newly formed string is valid
    private boolean isValid(String s){
        int count = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '(')
                count++;
            else if (s.charAt(i) == ')')
                count--;
            if (count < 0) return false;
        }
        return count == 0;
    }
}