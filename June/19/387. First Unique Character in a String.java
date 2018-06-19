class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        for (char c : arr){
            if (map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            }else{
                map.put(c, 1);
            }
        }
        for (int i = 0; i < arr.length; i++){
            if (map.get(arr[i]) == 1)
                return i;
            else continue;
        }
        return -1;
    }
}