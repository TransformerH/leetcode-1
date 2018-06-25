/**
 * use two stacks, one for ints, one for string
 * for ints, just simply push it onto stack once you see one
 * for string, save it into a temp string until you see '[', which is the hint of the start
 * of next string: so when seeing '[', push the previous string onto stack and start saving 
 * the new one
 * when ']' appears, it is the current 'res' that should be repeated
 * StringBuilder sb = new StringBuilder(string.pop())
 * sb.append(res) for n times
 */
class Solution {
    public String decodeString(String s) {
        String res = "";
        if (s == null || s == "") return res;  
        Stack<Integer> count = new Stack<>();
        Stack<String> string = new Stack<>();
        int i = 0;
        while (i < s.length()){
            if (Character.isDigit(s.charAt(i))){
                int temp = 0;
                while (Character.isDigit(s.charAt(i)))
                    temp = 10 * temp + (s.charAt(i++) - '0');
                count.push(temp);
            }else if (s.charAt(i) == '['){
                string.push(res);
                res = "";
                i++;
            }else if (s.charAt(i) == ']'){
                int temp = count.pop();
                StringBuilder sb = new StringBuilder(string.pop());
                for (int j = 0; j < temp; j++)
                    sb.append(res);
                res = sb.toString();
                i++;
            }else
                res += s.charAt(i++);   
        }
        return res;    
    }
}