class Solution {
    public int countPrimes(int n) {
        boolean[] res = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++){
            if (res[i] == false){
                count++; // false means prime
                for (int j = 2; i * j < n; j++){
                    res[i * j] = true; // true means not prime
                }
            }
        }
        return count;
    }
}
