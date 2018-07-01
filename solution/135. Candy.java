/** 
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?
*/
class Solution {
    public int candy(int[] ratings) {
        if (ratings.length == 0 || ratings == null) return 0;
        int[] res = new int[ratings.length];
        res[0] = 1;
        for (int i = 1; i < ratings.length; i++){
            if (ratings[i] > ratings[i - 1])
                res[i] = res[i - 1] + 1;
            else
                res[i] = 1;
        }
        int sum = res[ratings.length - 1];
        for (int i = ratings.length - 2; i >= 0; i--){
            if (ratings[i] > ratings[i + 1])
                res[i] = Math.max(res[i], res[i + 1] + 1);
            sum += res[i];
        }
        return sum;
    }
}