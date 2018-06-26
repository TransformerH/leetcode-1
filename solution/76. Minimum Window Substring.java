/**
Given a string S and a string T, find the minimum window in S which will contain 
all the characters in T in complexity O(n).

Example:
Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
 */

// sliding window, 非常非常重要
// minWindow的起始char都必须是被包含在t里

class Solution {
    public String minWindow(String s, String t) {  
        int[] count = new int[256];
        for (char c : t.toCharArray())
            count[c]++;
        int total = t.length();
        int start = 0, end = 0, index = 0, min = Integer.MAX_VALUE;
        while (end < s.length()){
            if (count[s.charAt(end++)]-- > 0) total--;
            while (total == 0){
                if (end - start < min) min = end - (index = start);
                if (count[s.charAt(start++)]++ == 0) total++;
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(index, index + min);
    }
}