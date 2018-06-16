import java.util.HashMap;
import java.util.Map;

/**
 * iterate through hashmap's keys:
 * Map<Integer, Integer>
 * for (int i: map.keySet())
 * iterate through hashmap's values:
 * for (int i : map.values())
 */
class Solution {
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (map.containsKey(c)){
                map.remove(c);
            }else{
                map.put(c, 1);
            }
        }
        int count = 0;
        for (Integer i : map.values()){
            if (i == 1) count ++;
        }
        return count > 1 ? false : true;
    }
}