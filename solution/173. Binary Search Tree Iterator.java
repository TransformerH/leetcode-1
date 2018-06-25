/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 /**
  * A Stack is used
  * 1. as long as there is a left child, add it to the stack
  * since BST (inorder) is increasing, the most left child will be the smallest number
  * 2. When next() is called, the smallest (top on the stack) node will be returned, then we will need to
  * add his right children onto the stack since his right children are definitely smaller than any one 
  * above him
  */
public class BSTIterator {
    private Stack<TreeNode> stack;
    private TreeNode pos;
    
    public BSTIterator(TreeNode root) {
        pos = root;
        stack = new Stack<>();
        while (pos != null){
            stack.push(pos);
            pos = pos.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode cur = stack.pop();
        TreeNode temp = cur;
        if (temp.right != null){
            temp = temp.right;
            while (temp != null){
                stack.push(temp);
                temp = temp.left;          
            }
        }
        return cur.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */