package com.leetcode.binary;

//        Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i]
//        is the number of 1's in the binary representation of i.
//
//        Example 1:
//        Input: n = 2
//        Output: [0,1,1]
//        Explanation:
//        0 --> 0
//        1 --> 1
//        2 --> 10
//
//        Example 2:
//        Input: n = 5
//        Output: [0,1,1,2,1,2]
//        Explanation:
//        0 --> 0
//        1 --> 1
//        2 --> 10
//        3 --> 11
//        4 --> 100
//        5 --> 101

import java.util.Arrays;

public class CountingBits_338 {

    public static void main(String[] args) {
        int[] bitsOffset = countBitsOffset(5);
        System.out.println("Result: " + Arrays.toString(bitsOffset));
    }

    /**
     * Time complexity: O(logn)
     * Space complexity: O(n)
     *
     * @param n
     * @return
     */
    public static int[] countBitsOffset(int n) {
        int[] result = new int[n + 1];
        int offset = 1;

        for (int index = 1; index < n + 1; ++index) {
            if (offset * 2 == index) {
                offset *= 2;
            }
            result[index] = result[index - offset] + 1;
        }
        return result;
    }
}
