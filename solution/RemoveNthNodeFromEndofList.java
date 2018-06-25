class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        if (head == null) return null;
        ListNode pos1 = dummy;
        ListNode pos2 = dummy;
        pos1.next = head;
        for (int i = 0; i <= n; i++)
            pos1 = pos1.next;
        while (pos1 != null){
            pos1 = pos1.next;
            pos2 = pos2.next;
        }
        pos2.next = pos2.next.next;
        return dummy.next;
    }
}
