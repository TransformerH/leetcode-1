/**
sort the nums in ascending order:
then use i and j two indexes, i goes from 0 to n-1, which j goes from i - 1 back
once nums[i] and nums[j] divisible pair found, compare counter[j]+1 and counter[i]
if the new nums[i] is decided to be added in, then update the connector of i to the jth item
 
check the max counter[i] everytime i incrases: once max is updated, use index to point to the biggest item

then for output purpose, start from the item INDEX points at, go all the way back and add all into a list
 */
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int[] counter = new int[n];
        int[] connect = new int[n];
        int max = 0;
        int index = -1;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++){
            counter[i] = 1;
            connect[i] = -1;
            for (int j = i - 1; j >= 0; j--){
                if (nums[i] % nums[j] == 0){
                    if (counter[i] < counter[j] + 1){
                        counter[i] = counter[j] + 1;
                        connect[i] = j;
                    }
                }
            }
            if (counter[i] > max){
                max = counter[i];
                index = i; 
            }
        }
        List<Integer> res = new ArrayList<>();
        while (index != -1){
            res.add(nums[index]);
            index = connect[index];
         }
        return res;
    }
}