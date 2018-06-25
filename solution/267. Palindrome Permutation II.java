import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            if (map.containsKey(s.charAt(i)))
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            else
                map.put(s.charAt(i), 1);
        }
        int odd = 0;
        for (int i: map.entrySet()){
            if (i == 1)
                odd++;
        }
        if (odd > 1) return res;
    }
}