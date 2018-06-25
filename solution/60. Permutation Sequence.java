class Solution {
    public String getPermutation(int n, int k) {
        // time: O(n)
        // space: O(n)

        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n; i++){
            res.add(i);
        }
        int[] factorial = new int[n+1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++){
            factorial[i] = i * factorial[i-1];
        }
        StringBuilder sb = new StringBuilder();
        int seq = 0;
        k--;
        for (int i = n; i > 0; i--){
            seq = k / factorial[i-1];
            k %= factorial[i-1];
            sb.append(res.get(seq));
            res.remove(seq);
        }
        return sb.toString();
    }

}
