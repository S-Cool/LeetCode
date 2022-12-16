package com.leetcode.binary;

//        Given two integers a and b, return the sum of the two integers without using the operators + and -.
//
//        Example 1:
//        Input: a = 1, b = 2
//        Output: 3

//        Example 2:
//        Input: a = 2, b = 3
//        Output: 5

public class SumOfTwoIntegers371 {

    public static void main(String[] args) {
        int sum = getSum(9, 11);
        System.out.println("Result: " + sum);
    }

    public static int getSum(int a, int b) {
        while (b != 0) {
            int tmp = (a & b) << 1;
            a = a ^ b;
            b = tmp;
        }
        return a;
    }

}
