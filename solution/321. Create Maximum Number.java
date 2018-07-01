/**
two subproblems:
// 1. pick k numbers from each array( relative order must be preserved )
// use greedy algorithms, throw at most (n - k) numbers
1. merge two arrays based on ???
2. take k numbers from the merged one???

1. pick max x from nums1 and max y from nums2 and dynamically increase x and decrease y
2. compare the res[] and return the biggest one


function1: compare two arrays
function2: merge two arrays of size k
function3: maxArray to select max size of x from an array
 */

class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int[] res = new int[k];
        for (int i = Math.max(0, k - n); i <= k && i <= m; i++){
            int[] temp = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
            if (bigger(temp, 0, res, 0)) res = temp;
        }
        return res;
    }
    private int[] merge(int[] nums1, int[] nums2, int k){
        int[] res = new int[k];
        for (int i = 0, j = 0, r = 0; r < k; r++){
            res[r] = bigger(nums1, i, nums2, j)? nums1[i++] : nums2[j++];
        }
        return res;
    }
    private int[] maxArray(int[] nums, int k){
        int n = nums.length;
        int[] res = new int[k];
        for (int i = 0, j = 0; i < n; i++){
            while (n - k > i - j &&  j > 0 && res[j - 1] < nums[i]) j--;
            if (j < k) res[j++] = nums[i];
        }
        return res;
    }
    private boolean bigger(int[] nums1, int i, int[] nums2, int j){
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]){
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }
}