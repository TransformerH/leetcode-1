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
    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }
    public int sum(TreeNode pos, int total){
        if (pos == null) return 0;
        if (pos.left == null && pos.right == null) return total*10 + pos.val;
        return sum(pos.left, total*10 + pos.val) + sum(pos.right, total*10 + pos.val);
    }
}
