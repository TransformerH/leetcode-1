import java.awt.List;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    // 1. question itself
    // 先sort， O（N*LogN）
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        List<Integer> list = new ArrayList<>();
        while (i < nums1.length && j < nums2.length){
            if (nums1[i] < nums2[j]){
                i++;
            }else if (nums1[i] > nums2[j]){
                j++;
            }else{
                list.add(num1[i]);
                i++;
                j++;
            }
        }
        int[] res = new int[list.size()];
        int k = 0;
        for (int num : list){
            res[k++] = num;
        }
        return res;
    }

    // 用hashmap O（N）
    public int[] intersect2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums1){
            if (map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            }else{
                map.put(num, 1);
            }
        }
        for (int num : num2){
            if (map.containsKey(num) && map.get(num) > 1){
                list.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        int[] res = new int[list.size()];
        int k = 0;
        for (int num : list){
            res[k++] = num;
        }
        return res;
    }
    //2. followup 1:
    //What if the given array is already sorted? How would you optimize your algorithm?
    
    // 3. followup 2:
    // What if nums1's size is small compared to nums2's size? Which algorithm is better?

    // 4. followup 3:
    //What if elements of nums2 are stored on disk, and the memory is limited 
    // such that you cannot load all elements into the memory at once?

    //ANSWER:If only nums2 cannot fit in memory, put all elements of nums1 into a HashMap, 
    // read chunks of array that fit into the memory, and record the intersections.
    // If both nums1 and nums2 are so huge that neither fit into the memory, sort them
    //  individually (external sort), then read 2 elements from each array at a time in 
    // memory, record intersections.
}