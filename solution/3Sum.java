import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum15 {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> sol = new ArrayList<>();
        for (int i = 0; i < len-2; i++){
            if (i > 0 && nums[i] == nums[i-1]) continue;

            // 类似于2sum
            int j = i+1, k = len-1, sum = 0 - nums[i];
            while (j < k){
                if ( nums[j] + nums[k] == sum){
                    sol.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    while (j < k && nums[j] == nums[j+1] )
                        j++;
                    while (j < k && nums[k] == nums[k-1] )
                        k--;
                    j++;
                    k--;
                }else if (nums[j] + nums[k] < sum)
                    j++;
                else if (nums[j] + nums[k] > sum)
                    k--;
            }
        }
        return sol;
    }

//    public List<List<Integer>> threeSum2(int[] nums) {
//        int len = nums.length;
//        Arrays.sort(nums);
//        List<List<Integer>> sol = new ArrayList<>();
//        for (int i = 0; i < len-2; i++){
//            if (i > 0 && nums[i] == nums[i-1]) continue;
//            for (int j = i+1; j < len - 1; j++){
//                for (int k = len-1; k > j; k--){
//                    if (nums[i] + nums[j] + nums[k] == 0)
//                        sol.add(Arrays.asList(nums[i],nums[j],nums[k]));
//                    while (k> j && nums[k] == nums[k-1]) k--;
//                }
//                while ( j < len-2 && nums[j] == nums[j+1]) j++;
//            }
//        }
//        return sol;
//    }
}
