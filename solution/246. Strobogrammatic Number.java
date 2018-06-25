import java.util.HashMap;
import java.util.Map;
class Solution {
    /**
     * need to confirm????
     * time O(N)
     * space O(1)
     */
    public boolean isStrobogrammatic(String num) {
        if (num.length() == 0 || num == null) return true;
        Map<Character, Character> map = new HashMap<>();
        map.put('1', '1');
        map.put('6', '9');
        map.put('9', '6');
        map.put('8', '8');
        map.put('0', '0');
        
        int start = 0;
        int end = num.length() - 1;
        
        while (start <= end){
            if (!map.containsKey(num.charAt(start))){
                return false;
            }else{
                if (num.charAt(end) != map.get(num.charAt(start)))
                    return false;
                else{
                    start++;
                    end--;
                }
            }
            
        }  
        return true;
    }
}