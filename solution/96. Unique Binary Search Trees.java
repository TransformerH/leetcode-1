class Solution {
    public int numTrees(int n) {
        // n = 3
        // root = 1, left has 0 nodes and right has 2 nodes => f(0) * f(2)
        // root = 2, left has 1 node and right has 1 node => f(1) * f(1)
        // root = 3, left has 2 nodes and right has 0 node => f(2) * f(0)
        // total f(3) = f(0) * f(2) + f(1) * f(1) + f(2) * f(0)
        // f(n) = f(0) * f(n-1) + f(1) * f(n-2) * ... * f(n-1) * f(0)
        int[] res = new int[n+1];
        res[0] = 1;
        for (int i = 1; i <= n; i++){
            for (int j = 0; j < i; j++){
                res[i] += res[j] * res[i-j-1];
            }
        }
        return res[n];
    }
}
