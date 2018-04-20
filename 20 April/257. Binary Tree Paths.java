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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        helper(root, new String(), res);
        return res;
    }
    private void helper(TreeNode root, String temp, List<String> res){
        if (root != null && (root.left != null || root.right != null))
            temp = temp + root.val + "->";
        else if (root.left == null && root.right == null) {
            temp += root.val;
            res.add(temp);
        }
        if (root.left != null) helper(root.left, temp, res);
        if (root.right != null) helper(root.right, temp, res);
    }
}
