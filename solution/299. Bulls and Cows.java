import java.util.Map;

class Solution {
    public String getHint(String secret, String guess) {
        /**
         * time O(N)
         * space O(N)
         */
        if (secret.length() == 0 || guess.length() == 0 || secret == "" || guess == "") return "0A0B";
        int counter1 = 0;
        int counter2 = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < guess.length(); i++){
            char temp = secret.charAt(i);
            if (temp == guess.charAt(i))
                counter1++;
            if (map.containsKey(temp)){
                map.put(temp, map.get(temp)+1);
            }else{
                map.put(temp, 1);
            }
        }
        for (int i = 0; i < guess.length(); i++){
            char temp = guess.charAt(i);
            if (map.containsKey(temp)){
                int num = map.get(temp);
                if (num == 0) continue;
                counter2++;
                map.put(temp, num-1);
            }
        }
        return counter1 + "A" + (counter2-counter1) + "B";
        
    }
}