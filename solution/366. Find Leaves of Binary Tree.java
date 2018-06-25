import java.util.ArrayList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * use height to memorize all the levels of each node, add them to the list position accordingly
 * 
 * height of a node is the # of edges from this node to left, so height of a leaf node is 0
 */
class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, res);
        return res;        
    }
    public int helper(TreeNode pos, List<List<Integer>> res){
        if (pos == null) return -1;
        int level = 1 + Math.max(helper(pos.left, res), helper(pos.right, res));
        if (res.size() < level + 1) res.add(new ArrayList<>());
        res.get(level).add(pos.val);
        return level;
    }
}