import java.util.Arrays;
import java.util.Comparator;

/**
 * 总体思路：(w, h)
 * 1. sort envelopes based on ascending w
 * 2. for same w envelopes, sort based on descending h
 * 3. after that，就只需要计算longest acending w 的envolope数量
 */
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0 || envelopes[0].length == 0) return 0;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare (int[] arr1, int[] arr2){
                if (arr1[0] == arr2[0])
                    return arr2[1] - arr1[1];
                else
                    return arr1[0] - arr2[0]; 
            }
        });
        int[] dp = new int[envelopes.length + 1];
        int len = 0;
        for (int[] envelop : envelopes){
            int index = Arrays.binarySearch(dp, 0, len, envelop[1]);
            if (index < 0)
                index = -(index + 1);
            dp[index] = envelop[1];
            if (index == len)
                len++;
        }
        return len;
    }
}