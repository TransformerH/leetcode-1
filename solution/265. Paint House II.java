class Solution {
    /**
     * 思路：
     * 假如，对于第一个房子来说，最小花费的是red，其次是blue
     * 那么，对于第二个房子来说，就有两种可能性，1是red之外的最小 和 第一个房子的red组合，
     * 2是所有的最小与第一个房子的第二小blue组合。
     * 
     * 两个变量，least，2ndleast
     */
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;

        int min1 = -1, min2 = -1;
        for (int i = 0; i < costs.length; i++){
            int last1 = min1;
            int last2 = min2;
            min1 = -1;
            min2 = -1;
            for (int j = 0; j < costs[0].length; j++){
                if (j != last1){
                    costs[i][j] += last1 < 0 ? 0 : costs[i-1][last1];
                }else{
                    costs[i][j] += last2 < 0 ? 0 : costs[i-1][last2];
                }

                if (min1 < 0 || costs[i][j] < costs[i][min1]){
                    min2 = min1;
                    min1 = j;
                }else if (min2 < 0 || costs[i][j] < costs[i][min2]){
                    min2 = j;
                }
            }
        }
        return costs[costs.length-1][min1];
    }
}