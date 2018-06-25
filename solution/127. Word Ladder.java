/**
 * Set集合不允许重复元素，是因为Set判断两个对象相同不是使用==运算符，而是根据equals方法。
 * 即两个对象用equals方法比较返回true，Set就不能接受两个对象。
 * 
 * Build 3 different hashsets：
 * 1. visited
 * 2. wordlist（copy题目中给的list<string>）
 * 3. temp
 * 
 * 1. 把beginWord加入visited set
 * 2. 只要visited里面没有endWord, 就把visited里的String取出来，一次替换一个character
 * 3. 如果wordlist这个set里存在替换了一个char之后的new String，就把它加入temp，然后把visited替换成temp（这时候结果就+1了）
 * 4. 如果wordlist里找不到任何一个当前string替换一个char之后的string，那么就代表进行不下去了，这个时候temp的size应该是0， 直接就return0，结束
 * 5. 不然的话就一直进行下去，直到找到了endWord，这时候visited里面就会有endWord,返回结果
 */

import java.util.HashSet;
import java.util.Set;
import com.sun.javafx.scene.control.behavior.ToolBarBehavior;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //bfs
        Set<String> visited = new HashSet<>();
        Set<String> words = new HashSet<>(wordList);
        visited.add(beginWord);
        int count = 1;
        while (!visited.contains(endWord)){
            Set<String> toBeAdded = new HashSet<>();
            for (String word: visited){
                for (int i = 0; i < word.length(); i++){
                    char[] temp = word.toCharArray();
                    for (char j = 'a'; j <= 'z'; j++){
                        temp[i] = j;
                        String tempString = new String(temp);
                        if (words.contains(tempString)){
                            toBeAdded.add(tempString);
                            words.remove(tempString);
                        }
                    }
                }
            }
            if (toBeAdded.isEmpty()) return 0;
            visited = toBeAdded;
            count++;
        }
        return count;
    }
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        // 用queue
    }
}