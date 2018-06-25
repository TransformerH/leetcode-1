import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * two ways to solve it:
 * 
 * method 1. use bfs
 * 1. build a map for all the  nodes and their corresponding connected nodes
 * 2. visit the first one and do DFS on it. add all visited nodes to a set
 * 3. count 
 * 
 * method 2. use union-find
 */

class Solution {
    public int countComponents(int n, int[][] edges) {
        /**
            This is 1D version of Number of Islands II. For more explanations, check out this 2D Solution.
            n points = n islands = n trees = n roots.
            With each edge added, check which island is e[0] or e[1] belonging to.
            If e[0] and e[1] are in same islands, do nothing.
            Otherwise, union two islands, and reduce islands count by 1.
            Bonus: path compression can reduce time by 50%.
         */
        int[] roots = new int[edges.length];
        for (int i = 0 ; i < n; i++){
            roots[i] = i;
        }
        for (int[] edge: edges){
            int pos1 = find(roots, edge[0]);
            int pos2 = find(roots, edge[1]);
            if (pos1 != pos2){
                roots[pos2] = pos1;
                n--;
            }
        }
        return n;
    }
    private int find(int[] roots, int id){
        while (roots[id] != id){
            roots[id] = roots[roots[id]];
            id = roots[id];
        }
        return id;
    }

    public int countComponents2(int n, int[][] edges) {
        if (n <= 1) return n;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++){
            map.put(i, new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++){
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < n; i++){
            if (set.add(i)){
                dfs(i, set, map);
                count++;
            }
        }
        return count;      
    }
    private void dfs(int i, Set<Integer> set, Map<Integer, List<Integer>> map){
        for (int j : map.get(i)){
            if (set.add(j)){
                dfs(j, set, map);
            }
        }
    }
}