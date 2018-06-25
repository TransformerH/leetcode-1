/**
 * sol 1: brute force
 * For every cell[i][j] in the grid, we count how many enemy we can hit on a row before we hit the wall. 
 * We do the same for column. The runtime for brute-forcing is O(mn*(m+n)), because we traverse the one 
 * row and one column for each cell we visit.
 * 
 * sol 2: memorization
 * 每行每列的第一个cell，或者是前面有wall的cell的时候，重新计算一次kill数量；
 * 如果前面没有wall的话，那两个相邻的cell能kill的数量是一样的
 * 
 * 所以从第一行开始循环：
 * 同一样的每一个cell share一样的rowKills，有不同的colKills（假设没有wall）
 * 
 * time O(mn), space O(n)
 */
class Solution {
    public int maxKilledEnemies(char[][] grid) {
        int m = grid.length;
        int n = m == 0 ? 0 : grid[0].length;
        if ( m * n == 0) return 0;
        int rowKills = 0;
        int[] colKills = new int[n];
        int max = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (i == 0 || grid[i-1][j] == 'W'){
                    colKills[j] = 0;
                    for (int k = i; k < m && grid[k][j] != 'W'; k++){
                        colKills[j] += grid[k][j] == 'E' ? 1 : 0;
                    }
                }
                if (j == 0 || grid[i][j-1] == 'W'){
                    rowKills= 0;
                    for (int k = j; k < n && grid[i][k] != 'W'; k++){
                        rowKills += grid[k][j] == 'E' ? 1 : 0;
                    }
                }
                if (grid[i][j] == '0')
                    max = Math.max(max, rowKills + colKills[j]);
            }
        }
        return max;
    }
}