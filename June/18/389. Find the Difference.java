import java.util.HashSet;
import java.util.Set;
/**
 * XOR ^
 * same = 0; diff = 1
 */
class Solution {
    public char findTheDifference(String s, String t) {
        char res = t.charAt(t.length() - 1);
        for (int i = 0; i < s.length(); i++){
            res ^= s.charAt(i);
            res ^= t.charAt(i);
        }
        return res;
    }
}