class Solution {
    public int nthUglyNumber(int n) {
        int[] res = new int[n];
        res[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        for (int i = 1; i < n; i++){
            res[i] = Math.min(Math.min (res[index2] * 2, res[index3] * 3), res[index5] * 5);
            if (res[i] == res[index2] * 2) index2++;
            if (res[i] == res[index3] * 3) index3++;
            if (res[i] == res[index5] * 5) index5++;
        }
        return res[n-1];
    }
}

// 1, 2, 3, 4, 5, 6, 8, 9, 10, 12,

// 1 -> 1 * 2 -> 1 * 3 -> 2 * 2 -> 2 * 3 -> 4 * 2 -> 2 * 5 -> 

// * 2
// * 3
// * 5