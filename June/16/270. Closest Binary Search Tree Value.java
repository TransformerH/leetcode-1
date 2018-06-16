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
    public int closestValue(TreeNode root, double target) {
        int res = root.val;
        while (root != null){
            if (Math.abs(res - target) > Math.abs(root.val - target))
                res = root.val;
            root = target > root.val ? root.right : root.left;
        }
        return res;
    }
}