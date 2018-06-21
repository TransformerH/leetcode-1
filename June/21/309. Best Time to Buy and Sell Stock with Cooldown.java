class Solution {
    /**
     * time O(N)
     * space O(1)
     * 
     * 1. state:
     * buy[i] : max profit till the ith day: the last action must be "buy"
     * sell[i]: max profit till the ith day: the last action must be "sell"
     * 
     * 2. transition:
     * buy[i] = max(buy[i-1], sell[i-2] - prices[i])
     * sell[i] = max(sell[i-1], buy[i-1] + prices[i])
     * => to save space,
     * b0 = max(b1, s2 - prices[i])
     * s0 = max(s1, b1 + prices[i])
     * 
     * 3. initial state:
     * day 0, can buy, cannot sell
     * b0 = -prices[0]
     * s0 = 0
     */
    public int maxProfit(int[] prices) {
        if (prices.length <= 1 || prices == null) return 0;
        int b0 = -prices[0], b1 = b0;
        int s0 = 0, s1 = 0, s2 = 0;
        for (int i = 1; i < prices.length; i++){
            b0 = Math.max(b1, s2 - prices[i]);
            s0 = Math.max(s1, b1 + prices[i]);
            b1 = b0;
            s2 = s1;
            s1 = s0;
        }
        return s0;
    }
}