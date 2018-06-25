class Solution {
    public int singleNumber(int[] nums) {
        // solution 1: basic solution - use HashMap
        // Map<Integer, Integer> res = new HashMap<Integer, Integer>();
        // for (int num : nums){
        //     if (!res.containsKey(num)){
        //         res.put(num, 1);
        //     }else{
        //         res.put(num, res.get(num) + 1);
        //     }
        // }
        // for (Integer o : res.keySet()){
        //     if (res.get(o).equals(1))
        //         return o;
        // }
        // return -1;

        // solution 2: bitwise operation
        int res = 0;
        for (int num : nums)
            res ^= num;
        return res;
    }
}
