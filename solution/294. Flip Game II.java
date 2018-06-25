import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean canWin(String s) {
        // backtrack / recursion
        // let the two parties take moves one after another and try all the possibilities
        
        // it involves too much duplicate computations
        
        for (int i = 0; i < s.length() - 1 ; i++){
            if (s.charAt(i) == '+' && s.charAt(i+1) == '+'){
                s = s.substring(0, i) + "--" + s.substring(i+2);
                boolean oppWin = canWin(s);
                s = s.substring(0, i) + "++" + s.substring(i+2);
                if (!oppWin)
                    return true;
            }
        }
        return false;
    }
    public boolean canWin2(String s) {
        //  recursion + DP
        // let the two parties take moves one after another and try all the possibilities
        // at the same time, memorize the results for all the strings

        // Sol with explaination:
        // https://leetcode.com/problems/flip-game-ii/discuss/73971/Java-backtracking-solution-with-time-optimization-through-DP(205ms-greater-19ms)

        Map<String, Boolean> map = new HashMap<>();
        return win(map, s);
    }
    public boolean win(Map<String, Boolean> map, String s){
        if (map.containsKey(s))
            return map.get(s);

        for (int i = 0; i < s.length() - 1 ; i++){
            if (s.charAt(i) == '+' && s.charAt(i+1) == '+'){
                s = s.substring(0, i) + "--" + s.substring(i+2);
                boolean oppWin = win(map, s);
                s = s.substring(0, i) + "++" + s.substring(i+2);
                if (!oppWin){
                    map.put(s, true);
                    return true;
                }
                    
            }
        }
        map.put(s, false);
        return false;
    }
}