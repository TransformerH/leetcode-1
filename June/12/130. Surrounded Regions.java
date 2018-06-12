/**
 * it can be solved by DFS/BFS:
 * 1. DFS:
 * any 'O' on the border of the board are not flipped to 'X'. 
 * Any 'O' that is not on the border and it is not connected to an 'O' on the 
 * border will be flipped to 'X'. 
 * 
 * solution:
 * find all the 'O' on the 4 borders and do DFS search on all of them to find all connected 'O'
 * change them to 'A'
 * change the rest of 'O' to 'X', 'A' back to 'O'
 */

class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        int m = board.length - 1;
        int n = board[0].length - 1;
        for (int i = 0; i <= m; i++){
            for (int j = 0; j <= n; j++){
                if (board[0][j] == 'O')
                    dfs(board, 0, j);
                if (board[m][j] == 'O')
                    dfs(board, m, j);
                if (board[i][0] == 'O')
                    dfs(board, i, 0);
                if (board[i][n] == 'O')
                    dfs(board, i, n);
            }
        }
        for (int i = 0; i <= m; i++){
            for (int j = 0; j <= n; j++){
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == 'A')
                    board[i][j] = 'O';
            }
        }
        
    }
    public void dfs(char[][] board, int i, int j){
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1) return;
        if (board[i][j] == 'O')
            board[i][j] = 'A';
        if (i > 1 && board[i-1][j] == 'O')
            dfs(board, i - 1, j);
        if (i < board.length - 2 && board[i+1][j] == 'O')
            dfs(board, i + 1, j);
        if (j > 1 && board[i][j-1] == 'O')
            dfs(board, i, j - 1);
        if (j < board[0].length - 2 && board[i][j+1] == 'O')
            dfs(board, i, j + 1);
    }
}