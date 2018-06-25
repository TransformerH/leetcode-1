class Solution {
    /**
     * time O(len1*len2)
     * space O(len1*len2)
     * 
     * Use DP:
     * part 1. state transfer function
     * 1. if two chars are the same: dp[i][j] = dp[i-1][j-1]
     * 2. not the same:
     * a. use 
     * insertion   insert in i   => dp[i][j-1] + 1
     * delete   delete a char in i => dp[i-1][j] + 1
     * replace     => dp[i-1][j-1] + 1
     * dp[i][j] = 1+ min (dp[i][j-1], dp[i-1][j], dp[i-1][j-1])
     * 
     * part 2. base case
     * dp[0][j] = j dp[i][0] = i
     */
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0 && word2.length() == 0) return 0;
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] costs = new int[len1+1][len2+1];
        for (int i = 1; i <= len1; i++){
            costs[i][0] = i;
        }
        for (int i = 1; i <= len2; i++){
            costs[0][i] = i;
        }
        for (int i = 1; i <= len1; i++){
            for (int j = 1; j <= len2; j++){
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    costs[i][j] = costs[i-1][j-1];
                }else{
                    costs[i][j] = 1 + Math.min(Math.min(costs[i-1][j], costs[i][j-1]), costs[i-1][j-1]);
                }
            }
        }
        return costs[len1][len2];
    }
}