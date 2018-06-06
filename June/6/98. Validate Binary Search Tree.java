// There are ints and there are Integers (there is no Java data type called integer).
// One is a primitive value, the other is an Object.
// int variables cannot be null, but Integer variables can be.

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
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean helper(TreeNode pos, long min, long max){
        if (pos == null) return true;
        if (pos.val >= max || pos.val <= min) return false;
        return helper(pos.left, min, pos.val) && helper(pos.right, pos.val, max);
    }
}
