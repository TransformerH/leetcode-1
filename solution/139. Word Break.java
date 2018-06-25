class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

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
}
