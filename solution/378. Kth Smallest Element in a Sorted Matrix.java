/**
 * similar as 373. Find K Pairs with Smallest Sums
 * 
 * Build a min Heap, put first row inside the heap with its correcpoinding x and y axis
 * 
 * loop for (k - 1) times,everytime poll out the top value from heap and add the next 
 * value in its column
 * 
 * finally return the top value on heap
 */
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix.length == 0 ||  matrix[0].length == 0) return -1;
        int n = matrix.length;
        
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int i = 0; i < n; i++)
            queue.offer(new int[]{ 0, i, matrix[0][i] });
        for (int i = 0; i < k - 1; i++){
            int[] temp = queue.poll();
            if (temp[0] == n - 1) continue;
            queue.offer(new int[]{temp[0] + 1, temp[1], matrix[temp[0] + 1][temp[1]]});
        }
        int[] res = queue.poll();
        return res[2];
    }
}