class Solution {
    public List<Integer> lexicalOrder(int n) {
        // 1开头，2开头，3开头。。。9开头
        
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= 9; i++)
            dfs(i, n, res);
        return res;
    }
    private void dfs(int cur, int n, List<Integer> res){
        if (cur > n)
            return;
        else{
            res.add(cur);
            for (int i = 0; i <= 9; i++){
                if (cur * 10 + i > n)
                    return;
                dfs(cur * 10 + i, n, res);
            }
        }
    }
}