class Solution {
    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < 9; i++){
            HashSet<Character> rows = new HashSet<>();
            HashSet<Character> cols = new HashSet<>();
            HashSet<Character> cells = new HashSet<>();
            for (int j = 0; j < 9; j++){
                 // first interate per row basis
                if (board[i][j] != '.' && !rows.add(board[i][j]))
                    return false;

                if (board[j][i] != '.' && !cols.add(board[j][i]))
                    return false;

                int row = (i/3) * 3;
                int col = (i%3) * 3;
                if ( board[row+j/3][col+j%3] != '.' && !cells.add(board[row+j/3][col+j%3]) )
                    return false;
            }
        }
        return true;
    }
}
