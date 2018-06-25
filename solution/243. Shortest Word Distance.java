class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int res = words.length;
        int a = -1;
        int b = -1;
        for (int i = 0; i < words.length; i++){
            if (words[i].equals(word1))
                a = i;
            else if (words[i].equals(word2))
                b = i;
            if (a != -1 && b != -1)
                res = Math.min(Math.abs(a - b), res);
        }
        return res;
    }
}