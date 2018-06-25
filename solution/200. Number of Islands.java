class Solution {
    public int m;
    public int n;
    public int numIslands1(char[][] grid) {
        // solution 1: DFS
        int res = 0;
        m = grid.length;
        if (m == 0) return 0;
        n = grid[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == '1'){
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int i, int j){
        if (i >= 0 && j >= 0 && i < m && j < n && grid[i][j] == '1'){
            grid[i][j] = '0';
            dfs(grid, i + 1, j);
            dfs(grid, i, j + 1);
            dfs(grid, i - 1, j);
            dfs(grid, i, j - 1);
        }
    }

    public int numIslands2(char[][] grid) {
        // solution 2: BFS
        int res = 0;
        m = grid.length;
        if (m == 0) return 0;
        n = grid[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == '1'){
                    bfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }
    public void bfs(char[][] grid, int x, int y){
        grid[x][y] = '0';
        int code = x * n + y;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(code);
        while (!queue.isEmpty()){
            code = queue.poll();
            int i = code / n;
            int j = code % n;
            if ( i - 1 >= 0 && grid[i-1][j] == '1'){
                queue.offer((i-1)*n + j);
                grid[i-1][j] = '0';
            }
            if ( i + 1 < m && grid[i+1][j] == '1'){
                queue.offer((i+1)*n + j);
                grid[i+1][j] = '0';
            }
            if ( j - 1 >= 0 && grid[i][j-1] == '1'){
                queue.offer( i * n + j - 1);
                grid[i][j-1] = '0';
            }
            if ( j + 1 < n && grid[i][j+1] == '1'){
                queue.offer(( i * n + j + 1);
                grid[i][j+1] = '0';
            }
        }
    }
}
