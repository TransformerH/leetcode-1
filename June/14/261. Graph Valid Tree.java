import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean validTree(int n, int[][] edges) {
        /**
         * solve it using DFS
         * use List<List<String>> to store all the edges
         * Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
            Output: false

            List<List<String>>的size就是n，对应n个nodes
            然后扫描一边所有的edges，把每个edges的右边nodes加入到对应的左边nodes
            e.g：
          list
            0   1
            1   0，2，3，4
            2   1，3
            3   1，2
            4   1

            （DFS）然后用一个hashset，保存所有的访问过的点
             加入第一个node 0 进入set
             访问set的所有的“子”nodes（访问就是指加入这些nodes到set）
             如果任何一个nodes被包含在了set里，就return false
         */
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++){
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++){
            list.get(edges[i][0]).add(edges[i][1]);
            list.get(edges[i][1]).add(edges[i][0]);
        }
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        boolean res = helper(visited, list, -1, 0);
        if (res == false) return res;
        return visited.size() == n ? true : false;
    }
    private boolean helper(Set<Integer> visited, List<List<Integer>> list, int parent, int cur){
        List<Integer> temp = list.get(cur);
        for (Integer i : temp){
            if (i == parent) continue;
            if (visited.contains(i)) return false;
            visited.add(i);
            boolean res = helper(visited, list, cur, i);
            if (res == false) return false;
        }
        return true;
    }
    public boolean validTree2(int n, int[][] edges) {
        // UNION FIND
    }
}