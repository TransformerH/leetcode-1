/**
 * serialize:
 * visit the binary tree in preorder, and mark null as X, add "~" in between all the nodes
 * 
 * deserialize:
 * split the string with "~", then place the string[] into a queue
 * recursively build a tree using the items from the queue
 * 
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }
    public void buildString(TreeNode root, StringBuilder sb){
        if (root == null){
            sb.append("X").append("~");
            return;
        }else{
            sb.append(root.val).append("~");
            buildString(root.left, sb);
            buildString(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, data.split("~"));
        return buildTree(list);
    }
    public TreeNode buildTree(List<String> list){
        String temp = list.remove(0);
        if (temp.equals("X")){
            return null;
        }else{
            TreeNode root = new TreeNode(Integer.valueOf(temp));
            root.left = buildTree(list);
            root.right = buildTree(list);
            return root;
        }
    }
}
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));