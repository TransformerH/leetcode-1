/**
 * recursive
 * 不重要
 */

class Solution {
    public boolean isScramble(String s1, String s2) {
        //1. different length
        if (s1.length() != s2.length()) return false;
        //2.check if there's any mismatch
        int[] nums = new int[26];
        for (int i = 0; i < s1.length(); i++){
            nums[s1.charAt(i) - 'a']++;
            nums[s2.charAt(i) - 'a']--; 
        }
        for (int num : nums){
            if (num != 0)
                return false;
        }
        for (int i = 1; i <= s1.length(); i++){
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i)))
                return true;
            if (isScramble(s1.substring(0, i), s2.substring(s1.length() - i)) && isScramble(s1.substring(s1.length() - i), s2.substring(0, i)))
                return true;
        }
        return false;
    }
}