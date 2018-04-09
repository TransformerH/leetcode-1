public class LongestSubstringWithoutRepeatingCharacters3 {
    /**
     * Given "abcabcbb", the answer is "abc", which the length is 3.
     * Given "bbbbb", the answer is "b", with the length of 1.
     * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer
     * must be a substring, "pwke" is a subsequence and not a substring.
     *  abc
     *
     *
     *
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        String temp = "";
        String res = "";
        temp += s.charAt(0);
        res += s.charAt(0);
        for (int i = 1; i < s.length(); i++){
            if (temp.lastIndexOf(s.charAt(i)) == -1){
                temp += s.charAt(i);
            }else{
                temp = temp.substring(temp.lastIndexOf(s.charAt(i))+1) + s.charAt(i);
            }
            if (temp.length() > res.length())
                res = temp;
        }
        return res.length();
    }
}
