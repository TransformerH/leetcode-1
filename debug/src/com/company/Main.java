package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println(addOperators("123", 6));
    }

    public static int myAtoi(String str) {
        str = str.trim();
        String res = "";
        boolean isNegative = false;
        if (str.length() == 0 || str == null) return 0;
        if (str.charAt(0) != '-' && str.charAt(0) < '0' || str.charAt(0) > '9') return 0;
        if (str.charAt(0) == '-') {
            isNegative = true;
        }
        int i;
        i = isNegative ?  1: 0;
        while (i < str.length()){
            if (str.charAt(i) <= '9' && str.charAt(i) >= '0') {
                res += str.charAt(i);
                i++;
            } else break;
        }
        if (Integer.parseInt(res) >= Math.pow(2,31)-1) return isNegative ? (int) -Math.pow(2,31) : (int) Math.pow(2,31)-1;
        return isNegative ? -Integer.parseInt(res) : Integer.parseInt(res);
    }
    public static List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0)
            return res;
        else if (num.length() == 1){
            if (num.charAt(0) - '0' == target)
                res.add(num);
            return res;
        }
        int result = num.charAt(0) - '0';
        String temp = "";
        temp += num.charAt(0);
        helper(res, num, target, temp, 1, result);
        return res;
    }
    private static void helper(List<String> res, String num, int target, String temp, int index, int result) {
        if (index == num.length() && target == result) {
            System.out.println("DONE");
            res.add(temp);
        }
        if (index > num.length() - 1 || (index == num.length() && target != result))
            return;

        int var = num.charAt(index) - '0';

        String operators = "+-*";
        for (int i = 0; i < operators.length(); i++) {
            int backup = result;
            switch (operators.charAt(i)) {
                case '+':
                    result += var;
                    break;
                case '-':
                    result -= var;
                    break;
                case '*':
                    result /= var;
                    break;
            }

            System.out.println(result);
            temp = temp + operators.charAt(i) + num.charAt(index);
            // System.out.println(temp);
            helper(res, num, target, temp, index + 1, result);
            result = backup;

        }
    }
}
