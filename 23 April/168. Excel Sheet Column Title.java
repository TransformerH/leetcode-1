class Solution {
    public String convertToTitle(int n) {
        String result = "";
        char temp;
        while (n > 0){
            n--;
            temp =  (char)('A' + n % 26 );
            result = temp + result;
            n /= 26;
        }
        return result;
    }
}
