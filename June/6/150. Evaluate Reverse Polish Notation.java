class Solution {
    // very straightfoward
    // just make sure to have the right operand positions for "-" and "/"
    // !!!  == and .equals() are different for Java objects
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++){
            if (tokens[i].equals("+")){
                int temp = stack.pop() + stack.pop();
                stack.push(temp);
            }else if (tokens[i].equals("-")){
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                stack.push(temp2 - temp1);
            }else if (tokens[i].equals("*")){
                int temp = stack.pop() * stack.pop();
                stack.push(temp);
            }else if (tokens[i].equals("/")){
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                stack.push(temp2 / temp1);
            }else{
                int temp = Integer.parseInt(tokens[i]);
                stack.push(temp);
            }
        }
        return stack.pop();
    }
}
