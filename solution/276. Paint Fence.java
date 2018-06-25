class Solution {
    /**
     * n fences with k colors
     * 
     * for the first 2 fences:
     * (case 1) same color  - k * 1
     * (case 2) different color - k * (k - 1)
     * so, for 2 posts => k + k * (k - 1)
     * 
     * what about n posts?
     * for the 3rd post:
     * same as the 2nd one: k * (k - 1) = different * 1
     * diff from the 2nd one: k * (k - 1) + k * (k - 1) * (k - 1) = (same + different)*(k-1)
     */
    public int numWays(int n, int k) {
        if (n == 0) return 0;
        else if (n == 1) return k;
        int sameColor = k;
        int diffColor = k * (k - 1);
        for (int i = 2; i <= n; i++){
            int temp = sameColor;
            sameColor = diffColor;
            diffColor = (temp + diffColor) * (k - 1);
        }
        return sameColor + diffColor;
    }
}