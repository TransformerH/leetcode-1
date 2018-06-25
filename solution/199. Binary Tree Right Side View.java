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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(res, root, 0);
        return res;
    }
    public void helper(List<Integer> res, TreeNode cur, int lvl){
        if (cur == null) return;
        if (res.size() <= lvl) res.add(cur.val);
        helper(res, cur.right, lvl + 1);
        helper(res, cur.left, lvl + 1);
    }
}
