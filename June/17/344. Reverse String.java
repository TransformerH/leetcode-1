class Solution {
    /**
     * time: O(N)
     * space: depends on language
     *  Java O(N) because String is immutable, and we need to create an array
     *  C/C++: O(1) because String is mutable
     */
    public String reverseString(String s) {
        char[] res = s.toCharArray();
        int i = 0;
        int j = res.length - 1;
        while (i <= j){
            char temp = res[i];
            res[i] = res[j];
            res[j] = temp;
            i++;
            j--;
        }
        return new String(res);
    }
}