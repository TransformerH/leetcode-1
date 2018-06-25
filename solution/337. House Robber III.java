import java.util.HashMap;
/**

1. stop criteria : when the root is null, nothing to rob, return 0;
2. since "It will automatically contact the police if two directly-linked houses 
were broken into on the same night":
a. rob the current house, skip the left child and right child
b. not rob the current house, rob its left child and right child instead

just compare a and b and choose the max one

when we start from root node, we'd compute root, root.left, root.right, root.left.left
root.left.right, root.right.left and root.right.right
then one level down, we'd computer root.most of the nodes again and again

since overlappting of subproblems do occur, it makes more sense to adpot DP

 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // rob(root) denotes the max money can be robbed starting root
    public int rob(TreeNode root) {
        return helper(root, new HashMap<>());
    }
    private int helper(TreeNode root, Map<TreeNode, Integer> map){
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);
        int val = 0;
        if (root.left != null)
            val += rob(root.left.left, map) + rob(root.left.right, map);
        if (root.right != null)
            val += rob(root.right.left, map) + rob(root.right.right, map);
        
        int res = Math.max(root.val + val, rob(root.left) + rob(root.right));
        map.put(root, res);
        return res;
    }

    // an int array is used to denote a node on whether it's robbed or not
    // still use dfs
    // time ? O(N) cause it visits all N nodes to do computation
    // space O(1)
    public int rob2(TreeNode root) {
        int[] res = helper(root);
        return Math.max(res[0], res[1]);
    }
    private int[] helper(TreeNode root){
        if (root == null) return new int[2];

        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int[] res = new int[2];
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);  //not rob root
        res[1] = left[0] + right[0] + root.val;
        return res;
    }
}