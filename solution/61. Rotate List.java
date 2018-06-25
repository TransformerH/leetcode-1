/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // Input: 1->2->3->  4->5->NULL, k = 2
        // Output: 4->5->1->2->3->NULL
        // 1, calculate List size
        // 2, go to the first node among nodes to be rotatad, set as pos1
        // 3, the node before as pos2 and points to null
        // 4, head -> pos1 ; pos1.tail -> head;

        if (head == null ) return head;
        ListNode pos = head;
        ListNode temp = head;
        ListNode head_prev = head;
        int count = 1;
        while (pos.next != null){
            pos = pos.next;
            count++;
        }

        k %= count;
        if (k == 0) return head;
        for (int i = 0; i < count - k - 1; i ++){
            temp = temp.next;
        }
        head = temp.next;
        temp.next = null;
        pos = head;
        for (int i = 0; i < k - 1; i++){
            pos = pos.next;
        }
        pos.next = head_prev;
        return head;
    }
}
