class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int rec1 = (C-A) * (D-B);
        int rec2 = (G-E) * (H-F);
        int overlap = 0;
        int right = Math.min(C, G);
        int left = Math.max(A, E);
        int top = Math.min(D, H);
        int bottom = Math.max(B, F);
        if (right > left && top > bottom)
            overlap = (right - left) * (top - bottom);
        return rec1 + rec2 - overlap;
    }
    public int computeArea2(int A, int B, int C, int D, int E, int F, int G, int H) {
        // easier compared to the first one
        // if the RIGHT point is to the left of LEFT point
        // and the TOP poit is to the bottom of BOTTOM point
        // there is no overlap then
    int left = max(A,E), right = max(min(C,G), left);
    int bottom = max(B,F), top = max(min(D,H), bottom);
    return (C-A)*(D-B) - (right-left)*(top-bottom) + (G-E)*(H-F);
    }
}
