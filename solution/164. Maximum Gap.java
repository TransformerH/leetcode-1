/**
 * Bucket Sort (桶排序) time O(N) 
 * Arrays.sort() : O(N*logN)
 */

/**
 * steps:
 * 1. find min and max of the array
 * 2. find gap - ceil of (max - min)/(N-1)
 * 3. build N-1 buckets to store the min and max value of each bukect
 * 4. put all the numbers into the buckets except for min and max
 * 5. scan array, find gap between each buckets as well as min and max
 */

class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2 || nums == null) return 0;
        int n = nums.length;
        int min = nums[0];
        int max = nums[0];
        // step1 find min/max
        for (int num : nums){
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        // step2 find gap
        int gap = (int) Math.ceil((max - min) / (n - 1));
        // step 3 build buckets
        int[] bucketMin = new int[n - 1];
        int[] bucketMax = new int[n - 1];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        // step4 put all numbers into buckets
        for (int num : nums){
            if (num == min || num == max) continue;
            int index = (num - min) / gap;
            bucketMin[index] = Math.min(num, bucketMin[index]);
            bucketMax[index] = Math.max(num, bucketMax[index]);
        }
        int res = Integer.MIN_VALUE;
        int prev = min;
        // step5 find maxGap
        for (int i = 0; i < n - 1; i++){
            if (bucketMin[i] == Integer.MAX_VALUE && bucketMax[i] == Integer.MIN_VALUE) 
                continue; // empty bucket
            res = Math.max(res, bucketMin[i] - prev);
            prev = bucketMax[i];
        }
        res = Math.max(res, max - prev);
        return res;
    }
}