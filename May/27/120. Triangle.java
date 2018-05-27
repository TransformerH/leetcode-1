class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // use bottom-up DP
        int[] minSum = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--){
            for (int j = 0; j < i+1 ; j++){
                minSum[j] = Math.min(minSum[j], minSum[j+1]) + triangle.get(i).get(j);
            }
        }
        return minSum[0];
    }
}
