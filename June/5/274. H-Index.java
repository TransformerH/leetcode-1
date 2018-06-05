class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        if (citations == null || n == 0) return 0;
        int[] res = new int[n + 1];
        for (int i = 0; i < n; i++){
            if (citations[i] >= n)
                res[n]++;
            else
                res[citations[i]]++;
        }
        for (int i = 0; i <= n; i++){
            System.out.println(res[i]);
        }
        int result = 0;
        for (int i = n; i >=0; i--){
            result += res[i];
            if (result >= i)
                return i;
        }
        return 0;
    }
}
