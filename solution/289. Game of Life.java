class Solution {
    public void gameOfLife(int[][] board) {
        /**
            - 00  dead (next) <- dead (current)
            - 01  dead (next) <- live (current)  
            - 10  live (next) <- dead (current)  
            - 11  live (next) <- live (current)

            1. in the beginning, each cell is default 00 or 01 (assume next state will be dead)
            2. count # of neighbors from 1st state and set 2nd state bit.
         ?? 3. Since every 2nd state is by default dead, no need to consider transition 01 -> 00
            4. In the end, delete every cell's 1st state by doing >> 1
         */
        if (board == null || board.length == 0) return;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                int count = countNeighbor(board, i, j);
                if (board[i][j] == 1){
                    if (count == 2 || count == 3)
                        board[i][j] += 2;
                        // 01 -> 11
                }else{
                    if (count == 3)
                        board[i][j] += 2;
                        // 00 -> 10
                }
            }
        }
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                board[i][j] >>= 1;
                // all shifting 1 bit to the right, so that the old state is removed
            }
        }
    }
    private int countNeighbor(int[][]board, int i, int j){
        int count = 0;
        for (int row = Math.max(0, i-1); row <= Math.min(i+1, board.length-1); row++){
            for (int col = Math.max(0, j-1); col <= Math.min(j+1, board[0].length-1); col++){
                if (row == i && col == j) continue;
                if ((board[row][col] & 1) == 1) count++;
            }
        }
        return count;
    }
}