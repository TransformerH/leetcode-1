/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode pos = head;
        ListNode dummy = new ListNode(0);
        // dummy.next = head;
        while (pos != null){
            ListNode temp = pos.next;
            ListNode prev = dummy;

            while (prev.next != null && prev.next.val < pos.val)
                prev = prev.next;

            pos.next = prev.next;
            prev.next = pos;
            // put pos between prev and prev.next

            pos = temp;
        }
        return dummy.next;
    }
}
