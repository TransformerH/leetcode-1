/**
 * Reservoir Sampling
 * 
 * time O(N)
 * space O(1)
 */
class Solution {
    private ListNode head;
    private Random random;
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
        random = new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        ListNode pos = head;
        int res = pos.val;
        for (int i = 1; pos.next != null; i++){
            pos = pos.next;
            if (random.nextInt(i+1) == i) res = pos.val;
        }
        return res;
    }
}