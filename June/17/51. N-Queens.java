import java.util.ArrayList;
/**
 * 1. queens[i]的意思是在第i行里queen的位置
 * 所以queens[0] 不能等于 queens[1] ，不然这样就有两个queen在同一列。
 * 
 * 2. index指的是在第几行
 * 
 * 3. 用backtrack做，
 *   把第一位设置成第一排放Q的地方，然后直接跳到第二排去；
 *   每放一次Q，就比较一次纵向和斜向是否有冲突，有的话就放这一排下一个位置，没有的话就继续下一排
 *   放到了n排后，就处理一下输出结果，然后继续寻找下一个解法。
 */
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        helper(res, new int[n], 0);
        return res;
    }
    private void helper(List<List<String>> res, int[] queens, int index){
        if (index == queens.length){
            addIntoRes(res, queens);
            return;
        }
        for (int i = 0; i < queens.length; i++){
            queens[index] = i;
            if (isQualified(queens, index)){
                helper(res, queens, index + 1);
            }
        }
    }
    private boolean isQualified(int[] queens, int index){
        for (int i = 0; i < index; i++){
            if (queens[i] == queens[index])
            //同样的位置，意味着在同一列
                return false; 
            else if (Math.abs(queens[i] - queens[index]) == Math.abs(i - index))
            //行数与列数的差距相等，意味着在对角线
                return false;
        }
        return true;
    }
    private void addIntoRes(List<List<String>> res, int[] queens){
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < queens.length; i++){
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < queens.length; j++){
                if (j == queens[i]) sb.append("Q");
                else sb.append(".");
            }
            temp.add(sb.toString());
        }
        res.add(temp);
    }
}