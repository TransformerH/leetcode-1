class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        return isMatch(0, pattern, 0, str, map);

    }
    private boolean isMatch(int i, String pattern, int j, String str, Map<Character, String> map){
        if (i == pattern.length() && j == str.length()) return true;
        if (i == pattern.length() || j == str.length()) return false;

        char c = pattern.charAt(i);
        if (map.containsKey(c)){
            String temp = map.get(c);
            String temp2 = map.get(pattern.charAt(i-1));
            if (!str.startsWith(temp, j)) {
                return false;
            }
            return isMatch(i + 1, pattern, j + temp.length(), str, map);
        }
        for (int start = j; start < str.length(); start++){
            String temp = str.substring(j, start + 1);
            if (!map.containsValue(temp)){
                map.put(c, temp);
                if (isMatch(i + 1, pattern, start + 1, str, map)) return true;
                map.remove(c);
            }
        }
        return false;
    }
}