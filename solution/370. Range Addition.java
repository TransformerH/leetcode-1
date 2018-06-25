class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        // native appraoch
        int[] res = new int[length];
        for (int[] update : updates){
            int start = update[0];
            int end = update[1];
            int var = update[2];
            for (int i = start; i <= end; i++){
                res[i] +=va;
            }
        }
        return res;
    }
    public int[] getModifiedArray2(int length, int[][] updates) {
        // time O(k + n)
        int[] res = new int[length];
        for (int[] update : updates){
            int start = update[0];
            int end = update[1];
            int var = update[2];
            res[start] += var;
            if (end < res.length - 1) res[end+1] -= var;
        }
        int sum = 0;
        for (int i = 0; i < length; i++){
            sum += res[i];
            res[i] = sum;
        }
        return res;
    }
}