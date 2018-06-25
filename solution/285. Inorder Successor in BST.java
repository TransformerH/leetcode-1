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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        /**
         * HINT: the successor of p should be the node that is just bigger than p
         * cause it's BST
         * 
         * case 1: node p has a right subtree
         * =>successor is the leftmost of the right subtree 
         * (a.k.a the node with min value in the right subtree of p)
         * 
         * case 2: p has no right subtree
         * return the ancestor node of p that is just in the RIGHT of p
         * how to find the ancestor node?
         * ans: mark the root as the start node, keep compare the start node with the p node
         * if p is bigger, go to right; if p is smaller go to left - and keep updating the ancestor node 
         * (always make sure that it's bigger than p)
         * 
         * time O(h) -> h = logn
         * space O(1)
         */
        TreeNode res = null;
        if (p.right != null){
            res = p.right;
            while (res.left != null)
                res = res.left;
        }else{
            TreeNode pos = root;
            while (pos != p){
                if (pos.val < p.val){
                    pos = pos.right;
                }else{
                    res = pos;
                    pos = pos.left;
                }
            }
        }
        return res;
    }
}