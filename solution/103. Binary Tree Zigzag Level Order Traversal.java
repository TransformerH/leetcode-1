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

    // Queue is an interface. You can't instantiate an interface directly except via an anonymous inner class.
    // Typically this isn't what you want to do for a collection. Instead, choose an existing implementation. For example:
    // Queue<Integer> q = new LinkedList<Integer>();
    // or
    // Queue<Integer> q = new ArrayDeque<Integer>();
    // Typically you pick a collection implementation by the performance and concurrency characteristics you're interested in.

    // OFFER only offers a new value, but it might not be accepted, e.g. if the queue is full
    // POLL only polls for the value, but we accept the fact the value might not be there.
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int counter = 0;
        while (!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode pos = queue.poll();
                if (pos.left != null) queue.offer(pos.left);
                if (pos.right != null) queue.offer(pos.right);
                if (counter % 2 == 0)
                    temp.add(pos.val);
                else
                    temp.add(0, pos.val);
            }
            res.add(temp);
            counter++;
        }
        return res;
    }
}
