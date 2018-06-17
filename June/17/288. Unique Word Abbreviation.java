import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class ValidWordAbbr {
    private Map<String, Set<String>> abbr;

    public ValidWordAbbr(String[] dictionary) {
        abbr = new HashMap<>();
        for (String dic : dictionary){
            if (dic.length() > 2){
                String temp = "" + dic.charAt(0) + dic.substring(0, dic.length()-1).length() + dic.charAt(dic.length()-1);
                if (abbr.containsKey(temp)){
                    abbr.get(temp).add(dic);
                }else{
                    Set<String> list = new HashSet<>();
                    list.add(dic);
                    abbr.put(temp, list);
                }
            }
        }
    }
    
    public boolean isUnique(String word) {
        if (word.length() <= 2) return true;
        String temp = "" + word.charAt(0) + word.substring(0, word.length()-1).length() + word.charAt(word.length()-1);
        if (abbr.containsKey(temp)){
            if (abbr.get(temp).contains(word)){
                return abbr.get(temp).size() == 1? true : false; 
            }else{
                return false;
            }
        }else{
            return true;
        }
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */