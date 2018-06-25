/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        // Time: O(n)
        // Space: O(n)
        ListNode smallHead = new ListNode(0),
                    bigHead = new ListNode(0),
                    small = smallHead,
                    big = bigHead;
        while (head != null){
            ListNode temp = new ListNode(head.val);
            if (head.val < x){
                small.next = temp;
                small = small.next;
            }else{
                big.next = temp;
                big = big.next;
            }
            head = head.next;
        }
        small.next = bigHead.next;
        return smallHead.next;
    }
}
