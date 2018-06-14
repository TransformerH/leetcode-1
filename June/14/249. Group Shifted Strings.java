import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/**
 * 1. use a map to store all the string
 * key - 这个string和‘a’的差值
 * value -所有的这个类别的string
 * 
 * 2. 从map里一个一个iterate所有的key，然后取出value attach到res里
 */
class Solution {
    public List<List<String>> groupStrings(String[] strings) {    
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strings){
            int offset = str.charAt(0) - 'a';
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++){
                char temp = (char) (str.charAt(i) - offset);
                if (temp < 'a')
                    temp += 26;
                sb.append(temp);
            }
            if (map.containsKey(sb.toString())){
                map.get(sb.toString()).add(str);
            }else{
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(sb.toString(), list);
            }
        }
        for (String str: map.keySet()){
            res.add(new ArrayList<>(map.get(str)));
        }
        return res;
    }
}