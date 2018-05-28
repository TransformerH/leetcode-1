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
    // not only should the root be balenced, but also their left and right children be balanced(find out recursively)
    public boolean isBalanced(TreeNode root) {
    solution 1: a bit complex: O(n*logn)
        if (root == null) return true;
        return isBalanced(root.left) && isBalanced(root.right) && (Math.abs(findHeight(root.left)-findHeight(root.right)) <= 1);
    }
    private int findHeight(TreeNode root){
        if (root == null) return 0;
        return Math.max(findHeight(root.left), findHeight(root.right)) + 1;
    }

    public boolean isBalanced2(TreeNode root) {
    // solution 2: O(n), check if balanced at the time of calculating height
        return findHeight(root) != -1;
    }
    private int findHeight(TreeNode root){
        if (root == null) return 0;
        int left = findHeight(root.left);
        int right = findHeight(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1){
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
