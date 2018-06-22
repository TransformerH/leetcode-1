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
  * basic idea is to find the 2 numbers:
  the first one which is bigger than its next value
  the second one which is smaller than its prev

  like: 6 4 5 2 would be 6 and 2 for in order traversal of BST
  */
class Solution {
    private TreeNode first = null;
    private TreeNode second = null;
    private TreeNode prevNode = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        traverse(root);
        
        // do the swap here
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    private void traverse(TreeNode root){
        //INORDER
        if (root == null) return;
        
        traverse(root.left);
        
        if (first == null && root.val < prevNode.val){
            first = prevNode;
        }
        if (first != null && root.val < prevNode.val){
            second = root;
        }
        prevNode = root;
        
        traverse(root.right);
    }
}