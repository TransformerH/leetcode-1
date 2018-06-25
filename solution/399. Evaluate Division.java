import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 Graph:
 a/b = 1.0
 take a and b as two nodes, 1.0 will be the value on the edge

 build two hashmaps, one for nodes, one for values
 */

class Solution {
    private Map<String, List<String>> neighbors = new HashMap<>();
    private Map<String, List<Double>> weights = new HashMap<>();
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) { 
        double[] res = new double[queries.length];
        // a graph is built
        for (int i = 0; i < equations.length; i++){
            if (!neighbors.containsKey(equations[i][0])){
                neighbors.put(equations[i][0], new ArrayList<>());
                weights.put(equations[i][0], new ArrayList<Double>());
            }
            if (!neighbors.containsKey(equations[i][1])){
                neighbors.put(equations[i][1], new ArrayList<>());
                weights.put(equations[i][1], new ArrayList<>());
            }
            neighbors.get(equations[i][0]).add(equations[i][1]);
            weights.get(equations[i][0]).add(values[i]);
            neighbors.get(equations[i][1]).add(equations[i][0]);
            weights.get(equations[i][1]).add(1/values[i]);
        }   
        for (int i = 0; i < queries.length; i++){
            res[i] = dfs(queries[i][0], queries[i][1], new HashSet<String>(), 1.0);
        }
        return res;
    }
    private double dfs(String start, String end, Set<String> set, double value){
        if (set.contains(start) || !neighbors.containsKey(start))
            return -1.0;
        if (start.equals(end))
            return value;
        set.add(start); // add the thing to start iterating on for dfs
        int i = 0;
        for (String neighbor : neighbors.get(start)){
            double result = dfs(neighbor, end, set, value * weights.get(start).get(i++));
            if (result != -1.0)
                return result;
        }
        set.remove(start);
        return -1.0;
    }
}