import java.util.LinkedList;
import java.util.Stack;

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
    //[1,1],2,[1,1]
    // 遍历一边这个nestedList，最外面的数字是应该乘以总层数，依次递减：
    // 应该乘以总层数n 相当于是 累加n 次!
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) return 0;
        
        int res = 0, temp = 0;
        while (!nestedList.isEmpty()){
            List<NestedInteger> list = new LinkedList<>();
            for (NestedInteger n: nestedList){
                if (n.isInteger()){
                    temp += n.getInteger();
                }else{
                    list.addAll(n.getList());
                }    
            }
            res += temp;
            nestedList = list;
        }
        return res;
    }
}