class Solution {
    public String countAndSay(int n) {
        String res = "1";
        int i = 1;
        while (i < n){
            StringBuilder sb = new StringBuilder();
            char c = res.charAt(0);
            int count = 0;
            for (int j = 0; j <= res.length(); j++){
                if (j != res.length() && c == res.charAt(j)){
                    count++;
                }else{
                    sb.append(count);
                    sb.append(c);
                    if (j != res.length()){
                        // not reaching the end of res
                        count = 1;
                        c = res.charAt(j);
                    }
                }
            }
            res = sb.toString();
            i++;
        }
        return res;
    }
}
