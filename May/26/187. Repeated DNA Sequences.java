class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> occurred = new HashSet<String>(), repeated = new HashSet<String>();
        for (int i = 0; i < s.length() - 9; i++){
            String tens = s.substring(i, i + 10);
            if (!occurred.add(tens))
                repeated.add(tens);
        }
        return new ArrayList<String>(repeated);
    }
}
