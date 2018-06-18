import java.util.HashSet;
import java.util.Set;

class Solution {
    // build 2 sets:
    // use set1 to store all the numbers in nums1
    // then use set1 to check against nums2, put all those intersetions in se2
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums = new HashSet<>();
        Set<Integer> intersection = new HashSet<>();
        for (int num : nums1){
            nums.add(num);
        }
        for (int num : nums2){
            if (nums.contains(num)){
                intersection.add(num);
            }
        }
        int[] res = new int[intersection.size()];
        int i = 0;
        for (int num : intersection){
            res[i++] = num;
        }
        return res;
    }
}