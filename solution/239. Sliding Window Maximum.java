class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k <= 0) return new int[0];
        Deque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        int[] result = new int[n + 1 - k];
        int j = 0;
        for (int i = 0; i < n; i++){
            if (!deque.isEmpty() && deque.peekFirst() == i - k)
                deque.pollFirst();
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
                deque.pollLast();
            deque.offer(i);
            if (i + 1 >= k)
                result[j++] = nums[deque.peekFirst()];
        }
        return result;
    }
}