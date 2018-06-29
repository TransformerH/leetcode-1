/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0 || lists == null) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node : lists){
            if (node != null)
                queue.offer(node);
        }
        
        ListNode dummy = new ListNode(0);
        ListNode pos = dummy;
        while (!queue.isEmpty()){
            pos.next = queue.poll();
            pos = pos.next;
            if (pos.next != null)
                queue.offer(pos.next);
        }
        return dummy.next;
    }
}