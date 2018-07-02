/**
 * 1. count all chars in one array
 * 2. record the most left pos one char could appear in another array
 * 3. interate these two arrays to find best candidate for each pos
 */
class Solution {
    public String rearrangeString(String s, int k) {
        int n = s.length();
        int[] count = new int[26];
        int[] pos = new int[26];
        for (int i = 0; i < s.length(); i++)
            count[s.charAt(i) - 'a']++;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            int temp = findValidMax(count, pos, i);
            if (temp == -1) return "";
            pos[temp] = i + k;
            count[temp]--;
            sb.append( (char) ('a' + temp));
        }
        return sb.toString();
    }
    private int findValidMax(int[] count, int[] pos, int index){
        int res = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < count.length; i++){
            if (count[i] > 0 && count[i] > max && index >= pos[i]){
                max = count[i];
                res = i;
            }
        }
        return res;
    }
}