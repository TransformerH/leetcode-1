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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, new ArrayList<>(), root, sum);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> temp, TreeNode root, int sum){
        temp.add(root.val);
        if (root.val == sum && root.left == null && root.right == null) res.add(new ArrayList<>(temp));
        if (root.left != null) helper(res, temp, root.left, sum - root.val);
        if (root.right != null) helper(res, temp, root.right, sum - root.val);
        temp.remove(temp.size() - 1);

    }
}
