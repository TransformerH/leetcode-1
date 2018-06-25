class Solution {
    public String largestNumber(int[] nums) {
        boolean allZero = true;
        Integer[] res = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != 0)
                allZero = false;
            res[i] = nums[i];
        }
        if (allZero) return "0";

        Arrays.sort(res, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                String x = String.valueOf(a);
                String y = String.valueOf(b);
                return (y + x).compareTo(x + y);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (Integer num : res){
            sb.append(num);
        }
        return sb.toString();
    }
}
