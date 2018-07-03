import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
Given a list of unique words, find all pairs of distinct indices (i, j) in the 
given list, so that the concatenation of the two words, i.e. words[i] + words[j] 
is a palindrome.

Example 1:
Given words = ["bat", "tab", "cat"]
Return [[0, 1], [1, 0]]
The palindromes are ["battab", "tabbat"]

1. 
如果i 和 j 组合可以是回文，那么就是j + i 是回文，或者i + j是回文
其中有可能是单数/双数两种情况

比如 tab bat 这里的bat就是tab reverse
或者 bat tab 这里的bat就是tab reverse
或者 ta b at 

2. 要求是distint indices，所以要用一个map来确保两次得到的index不是同一个

 */
class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if (words.length == 0 || words == null) return res;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) map.put(words[i], i);
        for (int i = 0; i < words.length; i++){
            for (int j = 0; j <= words[i].length(); j++){
                String temp1 = words[i].substring(0, j);
                String temp2 = words[i].substring(j);
                if (isPalindrome(temp1)){
                    String temp2reverse = new StringBuilder(temp2).reverse().toString();
                    if (map.containsKey(temp2reverse) && map.get(temp2reverse) != i && temp1.length() != 0){
                        // temp2reverse + temp1 + temp2 will definitely be panlindrome then
                        List<Integer> list = new ArrayList<>();
                        list.add(map.get(temp2reverse));
                        list.add(i);
                        res.add(list);
                    }
                }
                if (isPalindrome(temp2)){
                    String temp1reverse = new StringBuilder(temp1).reverse().toString();
                    if (map.containsKey(temp1reverse) && map.get(temp1reverse) != i){
                        // temp1 + temp2 + temp1reverse will definitely be panlindrome
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(map.get(temp1reverse));
                        res.add(list);
                    }
                }
            }
        }
        return res;
    }
    private boolean isPalindrome(String str){
        int i = 0, j = str.length() - 1;
        while (i < j){
            if (str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}