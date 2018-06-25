import java.util.HashSet;
import java.util.Set;

class Solution {
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        char[] arr = s.toCharArray();
        for (int i = 0, j = arr.length - 1; i < j;){
            if (vowels.contains(arr[i]) && vowels.contains(arr[j])){
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }else if (!vowels.contains(arr[i]))
                i++;
            else if (!vowels.contains(arr[j]))
                j--;
        }
        return new String(arr);
    }
}