class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
    //bottom up DP?
        boolean[] result = new boolean[s.length() + 1];
        result[0] = true;
        //"leetcodehahaha"
        // ["hahaha","leet","code"]
        // i = 1,   2     3
        // j = 0,   0,1   0,1,2
        for (int i = 1; i <= s.length(); i++){
            for (int j = 0; j < i; j++){
                if (result[j] && wordDict.contains(s.substring(j,i)) ){
                    result[i] = true;
                    System.out.println(s.substring(j,i));
                    break;
                }
            }
        }
        return result[s.length()];
    }

    public boolean wordBreak2(String s, List<String> wordDict) {
        // recursive memorization?        
        return helper(new HashMap<>(), s, wordDict);
    }
    private boolean helper(Map<String, Boolean> map, String s, List<String> wordDict){
        if (map.containsKey(s))
            return map.get(s);
        if (wordDict.contains(s)){
            map.put(s, true);
            return true;
        }
        for (int i = 1; i < s.length(); i++){
            String left = s.substring(0, i);
            String right = s.substring(i);
            if (wordDict.contains(left) && helper(map, right, wordDict)){
                map.put(right, true);
                return true;
            }
        }
        map.put(s, false);
        return false;
    }
}
