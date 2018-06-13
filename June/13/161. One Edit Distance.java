import javax.lang.model.util.ElementScanner6;

class Solution {
    public boolean isOneEditDistance(String s, String t) {
        /**
         * assume the length difference of s and t either being 1 or 0:
         * then, once there is a char different:
         * 1. s < t: 
         * 2. s > t:
         * 3. s == t: rest should be the same
         * 
         * it already covers all the situations where abs(s - t) == 0 || 1, so if abs > 1, it's false
         */
        for (int i = 0; i < Math.min(s.length(), j < t.length()); i++){
            if (s.charAt(i) != t.charAt(i)){  
                if (s.length() == t.length()){
                    return s.substring(i+1).equals(t.substring(i+1));
                }else if (s.length() < t.length()){
                    return s.substring(i).equals(t.substring(i+1));
                }else{
                    return s.substring(i+1).equals(t.substring(i));
                }    
            }
        }
        return Math.abs(s.length() - t.length()) == 1;
    }
}