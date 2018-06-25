class Solution {
    public int findKthLargest(int[] nums, int k) {
        // sol1: quick select
        if (nums.length == 0 || nums == null) return 0;
        int left = 0;
        int right = nums.length - 1;
        while (true) {
            int pivot = partition(nums, left, right);
            if (pivot + 1 == k) return nums[pivot];
            else if (pivot + 1 > k )
                right = pivot - 1;
            else
                left = pivot + 1;
        }
    }
    public int findKthLargest2(int[] nums, int k) {
    //sol2: use priority queue
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num: nums){
            pq.offer(num);
            if (pq.size() > k)
                pq.poll();
        }
        return pq.peek();
    }
    
    public int partition(int[] nums, int left, int right){
        int pivot = nums[left];
        int l = left + 1;
        while (l <= right){
            if (nums[l] < pivot && nums[right] > pivot){
                swap(nums, l, right);
                l++;
                right--;
            }
            if (nums[l] >= pivot)
                l++;
            if (nums[right] <= pivot)
                right--;
        }
        swap(nums, left, right);
        return right;
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
