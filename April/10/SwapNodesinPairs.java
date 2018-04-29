class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        ListNode pos = head;
        int temp;
        while(pos != null && pos.next != null){
            temp = pos.val;
            pos.val = pos.next.val;
            pos.next.val = temp;
            pos = pos.next.next;
        }
        return head;
    }
}
