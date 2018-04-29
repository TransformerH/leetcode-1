class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pos = head;
        ListNode prev = dummy;
        boolean isDuplicate =false;
        while (pos.next != null ){

            if (pos.val == pos.next.val){
                pos.next = pos.next.next;
                isDuplicate = true;
            }else{
                if (isDuplicate){
                    prev.next = pos.next;
                    isDuplicate = false;
                }else{
                    prev = pos;
                }
                pos = pos.next;
            }
            if (pos.next == null && isDuplicate)
                prev.next = pos.next;
        }
        return dummy.next;
    }
}
