/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        while (fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //prev points to the last of the first half
        // slow points to the first of the 2nd half
        prev.next = null;
        ListNode pos1 = sortList(head);
        ListNode pos2 = sortList(slow);
        return merge(pos1, pos2);
    }
    public ListNode merge(ListNode l1, ListNode l2){
        // 1 , 3,   2, 1
        ListNode res = new ListNode(0);
        ListNode pos = res;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                pos.next = l1;
                l1 = l1.next;
            }else{
                pos.next = l2;
                l2 = l2.next;
            }
            pos = pos.next;
        }
        while (l1 != null){
            pos.next = l1;
            pos = pos.next;
            l1 = l1.next;
        }
        while (l2 != null){
            pos.next = l2;
            pos = pos.next;
            l2 = l2.next;
        }
        return res.next;
    }
}
