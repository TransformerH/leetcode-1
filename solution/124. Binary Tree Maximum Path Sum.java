/**
Given a non-empty binary tree, find the maximum path sum.
For this problem, a path is defined as any sequence of nodes from some starting 
node to any node in the tree along the parent-child connections. The path must 
contain at least one node and does not need to go through the root.

题目的意思是，可以从任何一个node出发，走向任何一个另外的node，但是不能走回头路

hint，用postorder，先visit 左右child，然后parent

进行recursive的时候，会计算出两个值，一个是以当前这个node为转折点的话，能得到的maxValue；
另一个是当前这个node只是一个中转点，那就只能取它的max（left，right）
 */

class Solution {
    private int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        helper(root);
        return maxSum;
    }
    private int helper(TreeNode root){
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        maxSum = Math.max(maxSum, root.val + left + right);
        return Math.max(left, right) + root.val;
    }
}