/**
dp[i] means the # of min cuts for the string of length i
hence, we should return dp[s.length()]
*/
class Solution {
    public int minCut(String s) {
        // the same while loop has been used for twice, need improvement
        int n = s.length();
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) dp[i] = i;
        for (int i = 0; i < n; i++){
            int left = i;
            int right = i;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)){
                if (left == 0) dp[right] = 0;
                else dp[right] = Math.min(dp[right], dp[left - 1] + 1); 
                left--;
                right++;
            }
            left = i;
            right = i + 1;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)){
                if (left == 0) dp[right] = 0;
                else dp[right] = Math.min(dp[right], dp[left - 1] + 1); 
                left--;
                right++;
            }
        }
        return dp[n - 1];
    }
    public int minCut2(String s) {
        int n = s.length();
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) dp[i] = i;
        for (int i = 0; i < n; i++){
            cut(dp, s, i, i);
            cut(dp, s, i, i + 1);
        }
        return dp[n - 1];
    }
    private void cut(int[] dp, String s, int left, int right){
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            if (left == 0) dp[right] = 0;
            else dp[right] = Math.min(dp[right], dp[left - 1] + 1);
            left--;
            right++;
        }
    }
}