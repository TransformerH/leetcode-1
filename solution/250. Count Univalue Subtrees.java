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
  * 1.所有的leaf nodes
    2. node 等于左右child nodes的情况
    3. node 等于左child或者右child（只有一个child）

    解题思路
    用post order traverse所有的node，所以一开始，就是最左边的两个leaf， 然后往上依次走
    也只有这种order才可以拿来比较一个node的左孩子和右孩子
  */
  class Solution {
    private int res;
    public int countUnivalSubtrees(TreeNode root) {
        res = 0;
        helper(root);
        return res;
    }
    private boolean helper(TreeNode root){
        if (root == null) return true;
        boolean left = helper(root.left);
        boolean right = helper(root.right);
        if (left && right){
            if (root.left != null && root.left.val != root.val)
                return false;
            if (root.right != null && root.right.val != root.val)
                return false;
            res++;
            return true;
        }
        return false;
    }
}