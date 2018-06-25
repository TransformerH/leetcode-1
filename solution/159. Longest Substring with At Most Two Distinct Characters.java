import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        /**
         * sliding window, something like 2-pointer
         * "ec e   b  a"
         * use a hashmap to maintain at most two distance chars
         * when we have more than 2 chars, remove the "overflow" in the leftmost side
         * always compare the res with (high - low) and choose the bigger one
         */
        if (s == null || s.length() == 0);
        int start = 0, end = 0;
        int res = 0;  
        Map<Character, Integer> map = new HashMap<>();
        while (end < s.length()){
            if (map.size() <= 2){
                char c = s.charAt(end);
                map.put(c, end);
                end++;
            }
            if (map.size() > 2){
                int leftMost = s.length();
                for (int i : map.values()){
                    leftMost = Math.min(leftMost, i);
                }
                start = leftMost + 1;
                char c = s.charAt(leftMost);
                map.remove(c);
            }
            res = Math.max(res, end - start);
        }
        return res;
    }
}