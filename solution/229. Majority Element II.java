class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums.length == 0 || nums == null) return res;
        int counter1 = 0,
            counter2 = 0,
            candidate1 = 1,
            candidate2 = 0;
        for (int num : nums){
            if (num == candidate1)
                counter1++;
            else if (num == candidate2)
                counter2++;
            else if (counter1 == 0){
                counter1 = 1;
                candidate1 = num;
            }else if (counter2 == 0){
                counter2 = 1;
                candidate2 = num;
            }else{
                counter1--;
                counter2--;
            }
        }
        counter1 = 0; counter2 = 0;
        for (int num: nums){
            if (num == candidate1)
                counter1++;
            if (num == candidate2)
                counter2++;
        }
        if (counter1 > nums.length/3){
            res.add(candidate1);
        }
        if (counter2 > nums.length/3 ){
            res.add(candidate2);
        }
        return res;
    }
}
