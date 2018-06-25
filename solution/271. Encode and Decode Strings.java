public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if (strs == null || strs.size() == 0) return "";
        String res = "";
        for (String s : strs){
            int tempLength = s.length();
            res += tempLength + "/" + s;
        }
        return res;
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        if (s == "" || s.length() == 0) return res;
        int start = 0;
        while (start < s.length()){
            int slash = s.indexOf('/', start);
            int temp = Integer.valueOf(s.substring(start, slash));
            res.add(s.substring(slash + 1, slash + temp + 1));
            start = slash + temp + 1;
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));