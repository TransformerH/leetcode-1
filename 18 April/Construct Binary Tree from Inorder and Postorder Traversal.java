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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(0, postorder.length - 1, 0, inorder.length - 1 , inorder,postorder);
    }
    public TreeNode helper(int startPost, int endPost, int startIn, int endIn, int[] inorder, int[] postorder){
        if (endPost < 0 || startIn > endIn)
            return null;
        TreeNode root = new TreeNode(postorder[endPost]);
        int inIndex = 0;
        for (int i = startIn; i <= endIn; i++){
            if (inorder[i] == root.val)
                inIndex = i;
        }
        root.left = helper(startPost, startPost + inIndex - startIn - 1, startIn, inIndex - 1, inorder, postorder);
        root.right = helper(startPost + inIndex - startIn, endPost - 1, inIndex + 1, endIn, inorder,postorder);
        return root;
    }
}
