/**
e.g.
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"

in this case, we just have to store all the essential elements of the path into an array
then, push all the "words" in stack;
if it's "..", pop from the stack;
if it's ".", continue;

but in java, if we use 
string.split("/+")
there will also be "" resulted
so this sorta strings should be eliminated when saving data to stack

if nothing meaningful exists in the string, a "/" should still be returned.
 */

class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] paths = path.split("/+");
        for (String s : paths){  
            if (s.equals("..")){
                if (!stack.isEmpty())
                    stack.pop();
            }   
            else if (!s.equals(".") && !s.equals(""))
                stack.push(s);
        }
        String res = "";
        if (stack.isEmpty())
            return "/";
        while (!stack.isEmpty()){
            res = "/" + stack.pop() + res;
        }
        return res;
    }
}