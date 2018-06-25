import java.util.ArrayList;
import java.util.LinkedList;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        // use a tempList to recieve all the non-integer at each round
        if (nestedList == null) return 0;
        int level = 1;
        int sum = 0;
        while (!nestedList.isEmpty()){
            List<NestedInteger> temp = new ArrayList<>();
            for (NestedInteger i : nestedList){
                if (i.isInteger){
                    sum += i.getInteger() * level;
                }else{
                    temp.addAll(i.getList());
                }
            }
            nestedList = temp;
            level++;
        }
        return sum;
    }
    public int depthSum2(List<NestedInteger> nestedList) {
        //用queue
        if (nestedList == null) return 0;

        int level = 1;
        int sum = 0;
        Queue<NestedInteger> queue = new LinkedList<>(nestedList);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                NestedInteger temp = queue.poll();
                if (temp.isInteger()){
                    sum += temp.getInteger() * level;
                }else{
                    queue.addAll(temp.getList());
                }
            }
            level++;
        }
        return sum;
    }
}