class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        if (citations == null || n == 0) return 0;
        int left = 0;
        int right = n - 1;
        while (left <= right){
            int mid = (right + left) >> 1;
            if ((n - mid) == citations[mid])
                return citations[mid];
            else if ((n - mid) > citations[mid])
                left = mid + 1;
            else
                right = mid - 1;
        }
        return n - left;
    }
}
