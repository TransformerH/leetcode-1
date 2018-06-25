import java.util.HashMap;
import java.util.Map;

/**
 * 1. 0 +/-
 * 2. overflow
 * 3. 整数
 * 4. 小数 - 循环/不循环
 */

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return String.valueOf(0);
        StringBuilder sb = new StringBuilder();
        sb.append((numerator > 0) ^ (denominator > 0) ? "-":"");
        long num =  Math.abs( (long) numerator);
        long den = Math.abs( (long) denominator);
        sb.append(num/den);
        num %= den;
        if (num == 0) return sb.toString();

        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        map.put(num, sb.length());
        while (num != 0){
            num *= 10;
            sb.append(num/den);
            num %= den;
            if (map.containsKey(num)){
                int temp = map.get(num);
                sb.insert(index, "(");
                sb.append(")");
            }else{
                map.put(num, sb.length());
            }
        }
        return sb.toString();
    }
}