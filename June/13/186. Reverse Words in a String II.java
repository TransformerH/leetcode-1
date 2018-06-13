class Solution {
    public void reverseWords(char[] str) {
        /**
         * Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
           Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
           step 1. reverse the whole char array
           step 2. reverse back each word
           step 3. deal with corner case
         */
        if (str.length == 0 || str == null) return;
        int start = 0;
        int end = str.length - 1;
        reverse(str, start, end);
        for (int i = 0; i <= end; i++){
            if (str[i] == ' '){
                reverse(str, start, i-1);
                start = i+1;
            }
        }
        reverse(str, start, end);        
    }
    public void reverse(char[] str, int start, int end){
        while (start < end){
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }
}