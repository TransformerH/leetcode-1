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
    public int kthSmallest(TreeNode root, int k) {
        int count = countChild(root.left);
        if (k == count + 1) return root.val;
        else if (k <= count) return kthSmallest(root.left, k);
        else return kthSmallest(root.right, k-count-1);
    }
    public int countChild(TreeNode root){
        if (root == null) return 0;
        return 1 + countChild(root.left) + countChild(root.right);

    }
}
