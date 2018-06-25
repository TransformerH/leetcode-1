/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = dummy.next;
        for (int i = 0; i < m - 1; i++){
            curr = curr.next;
            pre = pre.next;
        }
        for (int i = 0; i < n - m; i++){
            ListNode temp = curr.next;
            curr.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }
        return dummy.next;
    }
}
