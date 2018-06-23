import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        List<int[]> result = new ArrayList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> (a[0] + a[1] - b[0] - b[1]));
        if (m * n * k == 0) return result;
        for (int i = 0; i < m; i++)
            queue.offer(new int[]{nums1[i], nums2[0], 0});
        while (k-- > 0){
            int[] temp = queue.poll();
            result.add(new int[]{temp[0], temp[1]});
            while (temp[2] == n - 1) continue;
            queue.offer(new int[]{temp[0], nums2[temp[2] + 1], temp[2] + 1});
        }
        return result;
    }
}