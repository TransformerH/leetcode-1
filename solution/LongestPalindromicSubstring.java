class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 0 || s == null) return s;
        int longest = 0;
        String res = "";
        //dynamic programming
        boolean[][] flag = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++){
            for (int j = 0; j <= i; j++){
                flag[j][i] = s.charAt(i) == s.charAt(j) && ( (i - j <= 2) || flag[j+1][i-1]);
                if (flag[j][i] == true){
                    if (i - j + 1 > longest){
                        longest = i - j + 1;
                        res = s.substring(j,i+1);
                    }
                }
            }
        }
        return res;
    }
}
