// devide the original number as a block of thousands, then hundreds/tens/less than 20

class Solution {
    
    private final String[] thousands = new String[]{"", "Thousand", "Million", "Billion"};
    private final String[] tens = new String[]{"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] less_than_20 = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    
    public String numberToWords(int num) {
        String res = "";
        if (num == 0) return "Zero";
        int count = 0;
        while (num != 0){
            if (num % 1000 != 0){
                res = helper(num % 1000) + thousands[count] + " " + res;
            }
            count++;
            num /= 1000;
        }
        return res.trim();
    }
    private String helper(int num){
        if (num == 0)
            return "";
        else if (num < 20)
            return less_than_20[num % 20] + " ";
        else if (num < 100)
            return tens[num / 10] + " " + helper(num % 10);
        else
            return less_than_20[num / 100] + " Hundred " + helper(num % 100);
    }
}