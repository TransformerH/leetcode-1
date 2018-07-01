class Solution {
    public String shortestPalindrome(String s) {
        // easy to understand and implement, but takes O(N^2) time for worst case
        char[] arr = s.toCharArray();
        int i = 0,
            j = arr.length - 1;        
        int end = arr.length - 1;
        
        while (i < j){
            if (arr[i] == arr[j]){
                i++;
                j--;
            }else{
                i = 0;
                end--;
                j = end;
            }   
        }
        return new StringBuilder(s.substring(end + 1)).reverse().toString() + s;
    }
    public String shortestPalindrome(String s) {
        //用kmp
    }
}