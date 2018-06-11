/**
Question: Given a non-empty string containing only digits, determine the total number of ways to decode it.

DP in general:
4 steps:
1, state
dp[i] represents total # of ways to decode it from the first position to the ith position

2, init
dp[0] = 1, dp[1] = 1

3, transfer function
123 4
    i
dp[i] = dp[i-1]   ==> the ith digit itself as a way being decoded, which makes the # of ways the same as i-1
+ dp[i-2]  ==> the ith digit together with (i-1)th digit, as long as they the previous digit is not 0, and the two digit together is from 1 to 26

NOTE: if current digit is 0, then it cannot be decoded seperately, so dp[i] = dp[i-2]
if previous digit is 0, then it cannot be decoded together with the previous digit, so dp[i] = dp[i-1]

4, result  
dp[n]

 */
import javax.lang.model.util.ElementScanner6;

class Solution {
    public int numDecodings(String s) {
        if (s == "" || s.charAt(0) == '0' || s.length() == 0) return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < s.length(); i++){
            int prev = s.charAt(i-1) - '0';
            int cur = s.charAt(i) - '0';
            if (cur == 0 && prev == 0)
                return 0;
            if (cur == 0){
                dp[i+1] = dp[i-1];
                if (prev >= 3 || prev ==0) return 0;
            }            
            else if (prev == 0 || prev*10+cur > 26)
                dp[i+1] = dp[i];
            else
                dp[i+1] = dp[i] + dp[i-1];
        }
        return dp[s.length()];
    }
    public int numDecodings2(String s) {
        int cur = 1;
        int prev = 1;
        int n = s.length();
        for (int i = 1; i < n; i++){
            int temp = cur;
            if (s.charAt(i) == '0'){
                if (s.charAt(i-1) == '0' || s.charAt(i-1) >= '3')
                    return 0;
                cur = prev;
            }else if (s.charAt(i-1) > '0' && Integer.valueOf(s.substring(i-1, i+1)) < 26)
                cur += prev;
            prev = temp;
        }
        return cur;
    }
}