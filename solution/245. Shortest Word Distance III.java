class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int res = words.length;
        int a = res;
        int b = -res;
        for (int i = 0; i < words.length; i++){
            if (word1.equals(words[i]))
                a = i;
            if (word2.equals(words[i])){
                if (word1.equals(word2)){
                    a = b;
                }
                b = i;  
            }
            res = Math.min(Math.abs(a - b), res);
        }
        return res;
    }
}