class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char temp  = input.charAt(i);
            if (temp == '+' || temp == '-' || temp == '*'){
                List<Integer> al = diffWaysToCompute(input.substring(0, i));
                List<Integer> bl = diffWaysToCompute(input.substring(i+1));
                for (int x : al){
                    for (int y : bl){
                        if (temp == '+')
                            res.add(x + y);
                        else if (temp == '-')
                            res.add(x - y);
                        else 
                            res.add(x * y);
                    }
                }
            }
        }
        if (res.size() == 0)
            res.add(Integer.valueOf(input));
        return res;
    }
}