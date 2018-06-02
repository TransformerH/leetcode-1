/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        while (fast!= null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null){
            slow = slow.next;
        }// odd # of nodes

        prev.next = null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // reverse first half
        while (head.next != null){
            ListNode temp = head.next;
            head.next = temp.next;
            temp.next = dummy.next;
            dummy.next = temp;
        }

        ListNode p1 = dummy.next;

        while (p1 != null && slow!= null){
            if (p1.val != slow.val)
                return false;
            p1 = p1.next;
            slow = slow.next;
        }
        return true;
    }
}
