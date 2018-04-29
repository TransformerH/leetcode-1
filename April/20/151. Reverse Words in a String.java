public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0 || !s.contains(" ")) return s;
        String[] temp = s.trim().split("\\s+");
        String res = "";
        for (int i = temp.length -1; i > 0; i--){
            res = res + temp[i] + " ";
        }
        return res + temp[0];
    }
}
