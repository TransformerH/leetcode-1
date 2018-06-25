class Solution {
    public String multiply(String num1, String num2) {
        if ( num1.length() == 0 || num2.length() == 0) return "0";
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--){
            for (int j = num2.length() - 1; j >= 0; j--){
                int prod = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                prod += res[i + j + 1];
                res[i + j + 1] = prod % 10;
                res[i + j] += prod / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i : res){
            sb.append(i);
        }
        while (sb.length() != 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
