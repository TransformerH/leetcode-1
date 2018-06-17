class Solution {
    private int res = 0;
    public int totalNQueens(int n) {
        if (n <= 1) return n;
        helper(new int[n], 0);
        return res;
    }
    private void helper(int[] queens, int pos){
        if (pos == queens.length){
            res++;
            return;
        }
        for (int i = 0; i < queens.length; i++){
            queens[pos] = i;
            if (qualify(queens, pos)){
                helper(queens, pos + 1);
            }
        }
    }
    private boolean qualify(int[] queens,int pos){
        for (int i = 0; i < pos; i++){
            if (queens[i] == queens[pos])
                return false;
            else if (Math.abs(queens[i] - queens[pos]) == Math.abs(i - pos))
                return false;
        }
        return true;
    }
}