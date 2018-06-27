/**
 * 1. from left, the head item will be eliminated;
 * from right, only when remaining number is odd;
 * when it is eliminated, the new head will be will the next item which is (old head*step)
 * 
 * 2. since everytime half of the numbers are eliminated, the step will times 2 each round
 * 3. remaining items will deduce half each time
 * 4. from left and from right toggle each time
 * 
 * when the ramaining item is 1, it will be the answer
 */
class Solution {
    public int lastRemaining(int n) {
        int remaining = n;
        int step = 1;
        boolean from_left = true;
        int head = 1;
        while (remaining > 1){
            if (from_left || remaining % 2 == 1)
                head += step;
            remaining /= 2;
            step *= 2;
            from_left = !from_left;
        }
        return head;
    }
}