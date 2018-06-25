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
    public int countNodes(TreeNode root) {
        int h = calculateHeight(root);
        if (h == 0) return 0;
        int hRight = calculateHeight(root.right);
        if (hRight == h - 1){
            // left full, calculate right
            return (1 << (h - 1)) + countNodes(root.right);
        } else if (hRight < h - 1){
            // left not even full
            return (1 << (h - 2)) + countNodes(root.left);
        }
        return 0;
    }
    public int calculateHeight(TreeNode root){
        if (root == null) return 0;
        return 1 + calculateHeight(root.left);
    }
}
