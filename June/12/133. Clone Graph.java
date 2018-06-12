import java.util.HashMap;

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */

 /**
  * create a map to store the the copyed nodes' label(key) and node itself (value)

  using DFS, copy the nodes from the root node, add its neighbours;

  */
  public class Solution {
    public Map<Integer, UndirectedGraphNode> map = new HashMap<>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // DFS
        return dfs(node);
    }
    public UndirectedGraphNode dfs(UndirectedGraphNode start){
        if (start == null) return null;
        if (map.containsKey(start.label)){
            return map.get(start.label);
        }
        UndirectedGraphNode copy = new UndirectedGraphNode(start.label);
        map.put(copy.label, copy);
        for (UndirectedGraphNode each : start.neighbors){
            copy.neighbors.add(dfs(each));
        }
        return copy;
    } 
}