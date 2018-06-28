class Solution {
    public int lengthLongestPath(String input) {
        int maxLen = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (String s : input.split("\n")){
            int level = 1 + s.lastIndexOf("\t");

            while (level + 1 != stack.size()) stack.pop(); 
            // 加入一个level的时候，level数必须等于stack的size（level从0开始的）

            int len = stack.peek() + s.length() - level + 1;
            stack.push(len);
            if (s.contains(".")) maxLen = Math.max(maxLen, len - 1);
        }
        return maxLen;
    }
}