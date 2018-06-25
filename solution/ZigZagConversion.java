class Solution {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0) return s;
        if (numRows <= 1) return s;
        String[] res = new String[numRows];
        String result = "";
        int index = 0;
        for (int i = 0; i < numRows; i++)   res[i] = "";
        for (int i = 0; i < s.length(); i++){
            index = i % (2 * numRows - 2);
            index = index < numRows ? index: 2 * numRows - 2 - index;
            res[index] += s.charAt(i);
        }
        for (int i = 0; i < numRows; i++)   result += res[i];
        return result;
    }
}
