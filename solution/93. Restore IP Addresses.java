import java.util.ArrayList;

/**
Given a string containing only digits, restore it by returning all possible valid IP address combinations.
Example:
Input: "25525511135"
Output: ["255.255.11.135", "255.255.111.35"]
*/

/**
 * basic idea:
 * use Bracktrack algorithms
 * 1. go through the string, verify each part (if it starts with 0 || bigger than 255), if okay add it to the results
 * use a variable called count to count how many parts have been added to the result (in total 4 parts)
 * 
 * 2. another thing to note is to add ".", which should be easy
 * 
 * 3. Time: O(1)
 *    Space: O(n)
 */

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        helper(0, s, res, new String(), 1);
        return res;
    }
    public void helper(int index, String s, List<String> res, String rets, int count){
        if (count == 5 && index == s.length()){
            res.add(new String(rets));
            return;
        }
        if (count > 5)
            return;
        for (int i = 1; i < 4; i++){
            if (index + i > s.length()) break;
            String temp = s.substring(index, index + i);
            if ((temp.length() > 1 && temp.startsWith("0")) || (temp.length() == 3 && Integer.parseInt(temp) >= 256 )) continue;
            helper(index + i, s, res, rets + temp + (count == 4 ? "": "."), count + 1);
        }
    }
}