import java.util.LinkedList;
class Solution {
    /**
     * 1. travesal the whole matrix, call BFS on all the '1'(building)
     * 
     * 2. calculate shortest distances of all the '0's to this '1'
     * => now we can get sum of each '0' to all reachable buildings 
     * 
     * For example, if grid[2][2] == 0, distance[2][2] is the sum of shortest 
     * distance from this block to all reachable buildings.
     * 
     * 3. we also count how many buildings each '0' can reach -> reach[][]
     * as well as totalBuildingNum
     * 
     * 4. finally, traversal distance[][] to get the position that has shortest total distance
     * 
     */
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        int m = grid.length;
        int n = grid[0].length;
        int total = 0;
        final int[] shift = new int[]{0, 1, 0, -1, 0};
        int[][] distance = new int[m][n];
        int[][] reach = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 1){
                    // this is a bulding
                    total++;
                    queue.offer(new int[]{i, j});
                    boolean[][] isVisited = new boolean[m][n];
                    int level = 1;
                    while (!queue.isEmpty()){
                        
                        int size = queue.size();
                        for (int q = 0; q < size; q++){
                            int[] cur = queue.poll();
                            for (int k = 0; k < 4; k++){
                                int nextRow = cur[0] + shift[k];
                                int nextCol = cur[1] + shift[k+1];

                                if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && grid[nextRow][nextCol] == 0 && !isVisited[nextRow][nextCol]){
                                    isVisited[nextRow][nextCol] = true;
                                    distance[nextRow][nextCol] += level;
                                    reach[nextRow][nextCol]++;
                                    queue.offer(new int[]{nextRow, nextCol});
                                }
                            }
                        }
                        level++;
                    }
                    

                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 0 && reach[i][j] == total){
                    res = Math.min(res, distance[i][j]);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;

        
    }
}