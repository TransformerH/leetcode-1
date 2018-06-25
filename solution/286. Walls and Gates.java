class Solution {
    public void wallsAndGates(int[][] rooms) {
        /**
         * Find all the '0' and do DFS on it
         * if the cell is filled with -1 or out of range 
         * OR the cell has a value smaller than pre-assigned value => return;
         * fill the cell with a pre-calculated int
         * do dfs on the up, down, left and right cell with the pre-calculated int + 1;
         */
        if (rooms == null || rooms.length == 0) return;
        int m = rooms.length;
        int n = rooms[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (rooms[i][j] == 0){
                    dfs(rooms, i, j, 0);
                }
            }
        }
    }
    public void dfs(int[][] rooms, int i, int j, int prev){
        if (i < 0 || j < 0 || i >= rooms.length || j >= rooms[0].length || rooms[i][j] < prev) 
            return;
        rooms[i][j] = prev;
        dfs(rooms, i - 1, j, rooms[i][j] + 1);
        dfs(rooms, i, j - 1, rooms[i][j] + 1);
        dfs(rooms, i + 1, j, rooms[i][j] + 1);
        dfs(rooms, i, j + 1, rooms[i][j] + 1);
            
    }
}