/**
 * only one solution was implemented which was similar as 247. Strobogrammatic Number II
 * 
 * find out all the different combinations with digits from low.length() to high.length()
 * then compare each String with low and high strings, count all those between these 2 ranges
 * 
 */
class Solution {
    public int strobogrammaticInRange(String low, String high) {
        int count = 0;
        List<String> result = new ArrayList<>();
        for (int i = low.length(); i <= high.length(); i++){
            result.addAll(helper(i, i));
        }
        for (String temp : result){
            if (temp.length() == low.length() && temp.compareTo(low) < 0) continue;
            if (temp.length() == high.length() && temp.compareTo(high) > 0) continue;
            count++;
        }
        return count;
    }
    private List<String> helper(int n, int m){
        if (n == 0) return Arrays.asList("");
        if (n == 1) return Arrays.asList("0", "8", "1");
        List<String> list = helper(n - 2, m);
        List<String> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++){
            String temp = list.get(i);
            if (n != m) res.add("0" + temp + "0");
            res.add("1" + temp + "1");
            res.add("8" + temp + "8");
            res.add("6" + temp + "9");
            res.add("9" + temp + "6");
        }
        return res;
    }
}