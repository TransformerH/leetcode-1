/**
 * use dfs on each char: whether to abbreaviate it or not
 * 
 * base case: after scanning all the chars, add the cur string to the result list and return
 * 
 */
class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        dfs(res, 0, 0, "", word);
        return res;
    }
    private void dfs(List<String> res, int pos, int count, String cur, String word){
        if (pos == word.length()){
            if (count > 0)
                cur += count;
            res.add(cur);
            return;
        }
        // abbreviate
        dfs(res, pos + 1, count + 1, cur, word);
        // keep the current char
        dfs(res, pos + 1, 0, cur+ (count > 0 ? count : "")+ word.charAt(pos), word);
    }
}