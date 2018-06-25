import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class WordDistance {
    
    private Map<String, List<Integer>> map;
    public WordDistance(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++){
            if (map.containsKey(words[i])){
                map.get(words[i]).add(i);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(words[i], list);
            }
        }
    }
    public int shortest(String word1, String word2) {
        int res = Integer.MAX_VALUE;
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int i = 0, j = 0; 
        while (i < list1.size() && j < list2.size()){
            if (list1.get(i) < list2.get(j)){
                res = Math.min(res, (list2.get(j) - list1.get(i)));
                i++;
            }else{
                res = Math.min(res, (list1.get(i) - list2.get(j)));
                j++;
            }
        }
        return res;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */