/**
 * recursive
 * first calculate the # of times each char occurs
 * then pick up those which is less than k and compare its left string and right string and select the bigger one
 * 
 * two base cases:
 * if the substring is less than k, return 0
 * if the substring does not contain any "less than k" char, return its full length
 */
class Solution {
    public int longestSubstring(String s, int k) {
        char[] array = s.toCharArray();
        return helper(array, 0, array.length - 1, k);
    }
    public int helper(char[] array, int start, int end, int k){
        if (end - start + 1 < k) return 0;
        int[] count = new int[26];
        for (int i = start; i <= end; i++){
            count[array[i] - 'a']++;
        }
        for (int i = 0; i < 26; i++){
            if (count[i] < k && count[i] > 0){
                for (int j = start; j <= end; j++){
                    if (array[j] == i + 'a'){
                        int left = helper(array, start, j - 1, k);
                        int right = helper(array, j+1, end, k);
                        return Math.max(left, right);
                    }
                }
            }
        }
        return end - start + 1;
    }
}