class Solution {
    public String removeDuplicateLetters(String s) {
        String res = "";
        char[] count = new char[256];
        boolean[] visited = new boolean[256];
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for (char c : arr){
            count[c]++;
        }
        for (char c : arr){
            count[c]--;
            if (visited[c])
                continue;
            while (!stack.isEmpty() && stack.peek() > c && count[stack.peek()] > 0){
                visited[stack.pop()] = false;
            }
            stack.push(c);      
            visited[c] = true;
        }
        for (char c : stack){
            res += c;
        }
        return res;      
    }
}