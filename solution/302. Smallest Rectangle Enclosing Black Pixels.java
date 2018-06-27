class Solution {
    public int minArea(char[][] image, int x, int y) {
        int m = image.length;
        int n = m == 0 ? 0 : image[0].length;
        if (m * n == 0) return 0;
        int left = searchCol(image, 0, y, 0, m, true);
        int right = searchCol(image, y + 1, n, 0, m, false);
        int top = searchRow(image, 0, x, 0, n, true);
        int bottom = searchRow(image, x + 1, m, 0, n, false);
        return (right - left) * (bottom - top);
    }
    public int searchCol(char[][] image, int i, int j, int top, int bottom, boolean opt){
        while (i < j){
            int mid = (i + j) / 2;
            int k = top;
            while (k < bottom && image[k][mid] == '0') 
                k++;
            if (k < bottom == opt)
                j = mid; // j is inclusive
            else i = mid + 1;
        }
        return i;
    }
    public int searchRow(char[][] image, int i, int j, int left, int right, boolean opt){
        while (i < j){
            int mid = (i + j) / 2;
            int k = left;
            while (k < right && image[mid][k] == '0') 
                k++;
            if (k < right == opt)
                j = mid; // j is inclusive
            else i = mid + 1;
        }
        return i;
    }
}