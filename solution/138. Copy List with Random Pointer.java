import java.util.HashMap;

import javax.print.attribute.HashAttributeSet;

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        /**
         * use hashmap
         * time: O(N)
         * space: O(N)
         */
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode pos = head;
        // step 1. save a copy of all the RandomListNode in the map
        while (pos != null){
            RandomListNode copy = new RandomListNode(pos.label);
            map.put(pos, copy);
            pos = pos.next;
            // copy = copy.next;
        }
        // step2. assign all the next and random pointers of the copies like originals
        pos = head;
        while (pos != null){
            map.get(pos).next = map.get(pos.next);
            map.get(pos).random = map.get(pos.random);
            pos = pos.next;
        }
        return map.get(head);
    }

    public RandomListNode copyRandomList2(RandomListNode head) {
        /**
         * NOT FINISHED YET!!!
         */
        if (head == null) return null;
        RandomListNode pos = head, next;

        // step 1.copy all the nodes one by one and put them side by side
        while (pos != null){
            next = pos.next;
            RandomListNode temp = new RandomListNode(pos.label);
            temp.next = pos.next;
            pos.next = temp;
            pos = next;
        }

        // step 2. copy all the random pointers
        pos = head;
        while (pos != null){
            RandomListNode pos2 = pos.next;
            if (pos.random != null)
                pos2.random = pos.random.next;
            pos = pos.next.next;
        }

        // step 3. restore the original list and extract the copy list
        pos = head;
        RandomListNode pos2 = head.next;
        
        while (pos != null && pos2 != null){
            pos.next = pos.next.next;
            if (pos2.next == null)
                break;
            pos2.next = pos2.next.next;
            pos = pos.next;
            pos2 = pos2.next;
        }
        return head.next;
    }
}