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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> bigger = new Stack<>();
        Stack<TreeNode> smaller = new Stack<>();
        while (root != null){
            if (root.val > target){
                bigger.push(root);
                root = root.left;
            }else{
                smaller.push(root);
                root = root.right;
            }
        }
        while (res.size() < k){
            if (bigger.isEmpty() || !smaller.isEmpty() && (bigger.peek().val - target > target - smaller.peek().val)){
                //??? WHY
                TreeNode temp = smaller.pop();
                res.add(temp.val);
                temp = temp.left;
                while (temp != null){
                    smaller.push(temp);
                    temp = temp.right;
                }
            }else{
                TreeNode temp = bigger.pop();
                res.add(temp.val);
                temp = temp.right;
                while (temp != null){
                    bigger.push(temp);
                    temp = temp.left;
                }
            }
        }
        return res;
    }
}