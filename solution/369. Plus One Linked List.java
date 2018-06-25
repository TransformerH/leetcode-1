/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode plusOne(ListNode head) {
        /**
         * use two pinters i and j
         * move j to the most right node
         * mode i to the most right node which is not 9
         * so when the most right one is 9, a carry operation is needed
         * otherwise, just a "plus one " will do
         */
        if (head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode i = dummy, j = dummy;
        while (j.next != null){
            j = j.next;
            if (j.val != 9)
                i = j;
        }
        if (j.val != 9)
            j.val++;
        else{
            i.val++;
            i = i.next;
            while (i != null){
                i.val = 0;
                i = i.next;
            }
        }
        return dummy.val == 0? dummy.next : dummy;
    }
}