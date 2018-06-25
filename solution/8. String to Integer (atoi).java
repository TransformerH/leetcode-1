class Solution {
    public int myAtoi(String str) {
        long res = 0;
        int sign = 1;
        str = str.trim();
        if (str.length() == 0 || str == null) return 0;
        int i = 0;
        if (str.charAt(i) == '-') {
            sign = -1;
            i++;
        }else if (str.charAt(i) == '+') {
            i++;
        }
        long temp = 0;
        while (i < str.length()){
            if (Character.isDigit(str.charAt(i))) {
                res = res * 10 + str.charAt(i) - '0' ;
                i++;
                if (sign == 1 && res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
                else if (sign == -1 && res > Integer.MAX_VALUE) return Integer.MIN_VALUE;
            }
            else
                break;
        }
        return sign * (int) res;
    }
}
