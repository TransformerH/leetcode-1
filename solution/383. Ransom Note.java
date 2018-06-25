class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] letters = new int[256];
        for (int i = 0; i < magazine.length(); i++){
            letters[magazine.charAt(i)]++;
        }
        for (int i = 0; i < ransomNote.length(); i++){   
            if (--letters[ransomNote.charAt(i)] < 0)
                return false;
        }
        return true;
    }
}