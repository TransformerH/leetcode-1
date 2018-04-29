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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, root);
        return res;
    }
    private void helper(List<Integer> res, TreeNode root){
        // left, root, right
        if (root.left != null) {
            // root = root.left;
            // res.add(root.val);
            helper(res, root.left);
        }
        if ( root != null) res.add(root.val);
        if (root.right != null) {
            // root = root.right;
            // res.add(root.val);
            helper(res, root.right);
        }
    }
}
