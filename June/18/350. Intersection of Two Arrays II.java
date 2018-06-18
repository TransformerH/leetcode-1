import java.awt.List;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    // 1. question itself
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
    //2. followup 1:
    //What if the given array is already sorted? How would you optimize your algorithm?
    
    // 3. followup 2:
    // What if nums1's size is small compared to nums2's size? Which algorithm is better?

    // 4. followup 3:
    //What if elements of nums2 are stored on disk, and the memory is limited 
    // such that you cannot load all elements into the memory at once?
}