class Solution {
    public boolean exist(char[][] board, String word) {
        // DP
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (helper(board, i, j, word, 0))
                    return true;
            }
        }
        return false;
    }
    public boolean helper(char[][] board, int i, int j, String word, int index) {
        if (index == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
        if (word.charAt(index) == board[i][j]){
            index++;
            char save = board[i][j];
            board[i][j] = '*';
            boolean res = helper(board, i+1, j, word, index) ||
                helper(board, i, j+1, word, index) ||
                helper(board, i, j-1, word, index) ||
                helper(board, i-1, j, word, index);
            board[i][j] = save;
            return res;
        }
        return false;
    }
}
