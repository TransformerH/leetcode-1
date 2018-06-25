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
