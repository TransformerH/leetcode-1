class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, new HashMap<>());
    }
    private List<String> dfs(String s, List<String> wordDict, Map<String, List<String>> map){
        if (map.containsKey(s)) return map.get(s);

        List<String> res = new ArrayList<>();

        if (s.length() == 0){
            res.add("");
            return res;
        }
        for (String word: wordDict){
            if (s.startsWith(word)){
                List<String> temp = dfs(s.substring(word.length()), wordDict, map);
                for (String sub : temp){
                    res.add(word + (sub.length() == 0 ? "" : " ") + sub);
                }
            }
        }
        map.put(s, res);
        return res;
    }
}