class Solution {
    public int minCost(int[][] costs) {
        /**
         * pain the (i+1)th house as red = 
         * min(paint the cur as blue, as green) + cost[i+1][0]
         * pain the (i+1)th house as blue = 
         * min(paint the cur as red, as green) + cost[i+1][1]
         * pain the (i+1)th house as green = 
         * min(paint the cur as red, as blue) + cost[i+1][2]
         * 
         * In general, the 2nd depends on the 1st one, the 3rd on the 2nd...
         * the last one depends on the 2nd last
         * 
         * then we will have 3 different costs, return the minimal one
         */

        if (costs == null || costs.length == 0) return 0;
        int n = costs.length - 1;
        for (int i = 1; i <= n ; i++){
            costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
        }
        return Math.min(Math.min(costs[n][0], costs[n][1]), costs[n][2]);
    }
}