/**
 * use two pinters i and j
 * use an int[] to count the # of occurances of all chars
 * move j to count all the chars and also update "res"
 * once distanct # of chars > k, move i in order to maintain at most k distinct chars
 */
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] count = new int[256];
        int indicator = 0;
        int i = 0;
        int res = 0;
        for (int j = 0; j < s.length(); j++){
            if (count[s.charAt(j)]++ == 0)
                indicator++;
            while (indicator > k){
                if (--count[s.charAt(i)] == 0)
                    indicator--;
                i++;
            }
            res = Math.max(j-i+1, res);
        }
        return res;
    }
}