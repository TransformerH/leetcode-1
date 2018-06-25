/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pos = head.next;
        ListNode fast = pos,
                 slow = pos,
                 prev = null;
        if (fast == null || fast.next == null) return;
        while (fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null; // cut into halves
        // pos is the head of the first half
        // slow is the head of the 2nd half
        slow = reverse(slow);
        dummy = dummy.next;
        while (slow != null && pos != null){
            // slow first, pos second
            dummy.next = slow;
            dummy = dummy.next;
            slow = slow.next;
            dummy.next = pos;
            dummy = dummy.next;
            pos = pos.next;
        }
        if (slow != null)
            dummy.next = slow;
        if (pos != null)
            dummy.next = pos;
    }
    public ListNode reverse(ListNode head){
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while (head.next != null){
            ListNode temp = head.next;
            head.next = temp.next;
            temp.next = dummy.next;
            dummy.next = temp;
        }
        return dummy.next;
    }
}
