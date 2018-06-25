class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int res = 0;
        int temp = Integer.MAX_VALUE;
        int result = target;
        for (int i = 0; i < nums.length-2; i++){
            for (int j = i+1; j < nums.length-1; j++){
                for (int k = j+1; k < nums.length; k++){
                    res = nums[i] + nums[j] + nums[k];
                    if (temp > Math.abs(res - target)){
                        temp = Math.abs(res - target);
                        result = res;
                    }

                    // temp = Math.min(temp, Math.abs(res - target));
//                    Math.abs(res - target) < temp ? temp = Math.abs(res - target) : res = temp;
                }
            }
        }
        return result;
    }
}
