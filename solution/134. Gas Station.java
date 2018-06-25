/**
 * two pointer pointing at start and end of the array:
 * sum will be # of gas minus # of cost at each location
 * if (sum >= 0), it means that the gas will be enough to reach next station => move the end pointer
 * else, means that the starting point won't have enough gas to carry on => move the start pointer
 * start and end together will cover the whole map
 * in the end, start will point to the position which is good to start
 * if SUM < 0, means that it can't complete the trip, thus return -1
 */
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = cost.length - 1;
        int end = 0;
        int sum = gas[start] - cost[start];
        while (start > end) {
            if (sum >= 0){
                sum += gas[end] - cost[end];
                end++;
            }else{
                start--;
                sum += gas[start] - cost[start];
            }
        }
        return sum >= 0 ? start: -1;
    }
}