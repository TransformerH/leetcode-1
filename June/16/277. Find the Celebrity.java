/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        /**
         * solution 1: brute force
         * check all the N candidates and ask each of of them the rest of the candidates
         *  O(N)
         */

         /**
          * solution 2: O(N)

          if knows(a,b) return false, means a doesnt know b => b is not a celebrity
          if return true, a knows b => a cannot be celebrity
          */
        int res = 0;
        for (int i = 1; i < n; i++){
            if (knows(res, i)){
                res = i;
            }
        }
        for (int i = 0; i < n; i++){
            if (i != res && knows(res, i) || !knows(i, res)) return -1;
        }
        return res;
    }
}