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
    /**
     * 从root开始DFS遍历所有的nodes，直到访问到每一个leaf节点
     * 每一次遍历到左孩子和右孩子的时候，都比较他们和父节点的value是不是差1：
     * 如果相差1说明是连续的，就count++， 不然count就变为1（就是当前的node）
     * 然后用一个res全局变量（global var）来记录所得到的最大的连续长度
     * return res
     * 
     * time O（n）最坏的情况都遍历一遍
     * space O(h）
     */
    private int res = 0;
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        helper(root, 0, 0, res);
        return res;
    }
    private void helper(TreeNode root, int target, int count) {
        if (root == null) return;
        if (root.val == target) count += 1;
        else count = 1;
        res = Math.max(count, res);
        helper(root.left, root.val + 1, count);
        helper(root.right, root.val + 1, count);
    }
}