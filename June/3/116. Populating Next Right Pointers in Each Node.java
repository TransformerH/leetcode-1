/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        if (root.left != null) root.left.next = root.right;
        if (root.next != null && root.right != null) root.right.next = root.next.left;
        connect(root.left);
        connect(root.right);
    }
    public void connect2(TreeLinkNode root) {
        // this solution also applied to when the binary tree is NOT perfect
        TreeLinkNode top = root;
        while (top != null){
            TreeLinkNode cur = top;
            TreeLinkNode prev = null;
            while (cur != null){
                if (cur.left != null){
                    if (prev != null)
                        prev.next = cur.left;
                    prev = cur.left;
                }
                if (cur.right != null){
                    if (prev != null)
                        prev.next = cur.right;
                    prev = cur.right;
                }
                cur = cur.next; // finish the whole next level before go to next level
            }
            // go to next level if there is, otherwise go to the next node
            top = top.left != null ? top.left : top.right != null ? top.right : top.next;

        }
    }
}
