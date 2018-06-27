/**
建一个list，把array倒着扫一遍，每个数都放入list，返回在list中的index

每个数在这个list的index都是它在array右边比它小的总数

*/
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Integer[] res = new Integer[nums.length];
        for (int i = nums.length - 1; i >= 0; i--){
            int index = findIndex(nums[i], list);
            res[i] = index;
            list.add(index, nums[i]);
        }
        return Arrays.asList(res);
    }
    private int findIndex(int num, List<Integer> list){
        if (list.size() == 0) return 0;
        int start = 0;
        int end = list.size() - 1;
        if (list.get(end) < num) return end + 1;
        if (list.get(start) >= num) return start;
        while (start < end){
            int mid = (end - start) / 2 + start;
            if (list.get(mid) < num)
                start = mid + 1;
            else
                end = mid;            
        }
        if (list.get(start) >= num) return start;
        return end;
    }
}