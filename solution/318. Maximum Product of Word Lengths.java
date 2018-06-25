    /**
     * Given a string array words, find the maximum value of length(word[i]) * length(word[j]) 
     * where the two words do not share common letters. 
     * 
     * write "abc" "def" as 012 and 345
     * 1 << 0 | 1 << 1 | 1 << 2      &      1 << 3 | 1 < 4 | 1< 5
     * would always be 0 as they have no common letter 
     * 
     * values[i] == 110000 中所有出现1的都是在这个word里出现的letter
     */

class Solution {
    public int maxProduct(String[] words) {
        int[] values = new int[words.length];
        for (int j = 0; j < words.length; j++){
            for (int i = 0; i < words[j].length(); i++){
                values[j] |= 1 << (word.charAt(i) - 'a');
            }
        }
        int res = 0;
        for (int i = 0; i < words.length - 1; i++){
            for (int j = 1; j < words.length; j++){
                if ((values[i] & values[j]) == 0 && (words[i].length() + words[j].length()) > res)
                    res = words[i].length() + words[j].length();
            }
        }
        return res;
    }
}