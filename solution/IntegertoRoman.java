class Solution {
    public String intToRoman(int num) {
        //2255
        String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};// 0-9
        String[] X = {"", "X", "XX","XXX","XL","L","LX","LXX", "LXXX", "XC"};// 0-90
        String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};//0-900
        String[] M = {"", "M", "MM", "MMM"}; //0-3000

        return M[num/1000] + C[(num/100)%10] + X[(num/10)%10] + I[num%10];

    }
}
