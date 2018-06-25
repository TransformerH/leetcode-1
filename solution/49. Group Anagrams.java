class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs.length == 0 || strs == null) return res;
        HashMap<String, Integer> map = new HashMap<>();
        for (String str : strs){
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String s = new String(temp);
            if (!map.containsKey(s)){
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(s, res.size());
                res.add(list);
            }else{
                List<String> list = res.get(map.get(s));
                list.add(str);
            }
        }
        return res;
    }
}
