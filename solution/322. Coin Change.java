class Solution {
    /**
     * time: O(n * amount) (n is the length of coins)
     * space: O(amount) for the array created
     */

    public int coinChange(int[] coins, int amount) {
        /**
         * easier to understand
         */
        if (coins == null || coins.length == 0) return -1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++){
            for (int amt = 1; amt <= amount; amt++){
                if (amt >= coins[i])
                    dp[amt] = Math.min(dp[amt], dp[amt-coins[i]] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }



    public int coinChange2(int[] coins, int amount) {
        return helper(coins, amount, new int[amount + 1]);
    }
    public int helper(int[] coins, int amt, int[] count){
        if (amt == 0) return 0;
        if (amt < 0) return -1;
        if (count[amt] != 0) return count[amt];
        int min = Integer.MAX_VALUE;
        for (int coin : coins){
            int res = helper(coins, amt - coin, count);
            if (res >= 0 && res < min)
                min = res + 1;
        }
        count[amt] = min == Integer.MAX_VALUE ? -1 : min;
        return count[amt];
    }
}