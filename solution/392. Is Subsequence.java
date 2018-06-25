class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0 || s == "") return true;
        
        char[] arr = t.toCharArray();
        int j = 0;
        for (int i = 0; i < arr.length; i++){
            if (s.charAt(j) == arr[i]){
                j++;
                if (j == s.length())
                    return true;
            }else{
                continue;
            }
            
        }
        return false;
    }
}