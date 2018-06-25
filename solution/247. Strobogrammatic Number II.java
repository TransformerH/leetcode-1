import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<String> findStrobogrammatic(int n) {
        // iterative
        List<String> one = new ArrayList(Arrays.asList("0", "1", "8"));
        List<String> two = new ArrayList(Arrays.asList(""));
        List<String> res = two;
        if (n % 2 == 1)
            res = one;
        for (int i = (n % 2) + 2; i <= n; i += 2){
            List<String> temp = new ArrayList<>();
            for (String s : res){
                if (i != n){
                    temp.add("0" + s + "0");
                }
                temp.add("1" + s + "1");
                temp.add("6" + s + "9");
                temp.add("9" + s + "6");
                temp.add("8" + s + "8");
            }
            res = temp;
        }
        return res;
    }
    public List<String> findStrobogrammatic2(int n) {
        // backtrack
        return helper(n, n);
    }
    private List<String> helper(int n, int m){
        if (n == 0) return new ArrayList<>(Arrays.asList(""));
        if (n == 1) return new ArrayList<>(Arrays.asList("0", "1", "8"));
        List<String> list = helper(n - 2, m);
        List<String> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++){
            String s = list.get(i);
            if (n != m) res.add("0" + s + "0");
            res.add("1" + s + "1");
            res.add("8" + s + "8");
            res.add("6" + s + "9");
            res.add("9" + s + "6");
        }
        return res;
    }

}