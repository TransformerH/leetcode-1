class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int number = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (Character.isDigit(c)){
                number = number * 10 + (c - '0');
            }else if (c == '+'){
                res += sign * number;
                sign = 1;
                number = 0;
            }else if (c == '-'){
                res += sign * number;
                sign = -1;
                number = 0;
            }else if (c == '('){
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            }else if (c == ')'){
                res += sign * number;
                number = 0;
                res *= stack.pop();
                res += stack.pop();
            }
        }
        if (number != 0) res += sign * number;
        return res;
    }
}