package com.leetcode.dynamic;

//        You are climbing a staircase. It takes n steps to reach the top.
//
//        Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
//
//        Example 1:
//        Input: n = 2
//        Output: 2
//        Explanation: There are two ways to climb to the top.
//        1. 1 step + 1 step
//        2. 2 steps
//
//        Example 2:
//        Input: n = 3
//        Output: 3
//        Explanation: There are three ways to climb to the top.
//        1. 1 step + 1 step + 1 step
//        2. 1 step + 2 steps
//        3. 2 steps + 1 step

public class ClimbingStairs_70 {

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
        System.out.println(climbStairsRecursive(5));
    }

    /**
     * Bottom Up Approach
     * <p>
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }

        int one = 1;
        int two = 1;
        for (int i = 0; i < n - 1; i++) {
            int temp = one;
            one = one + two;
            two = temp;
        }
        return one;
    }

    /**
     * Recursive Approach
     * <p>
     * Time complexity: O(2^n)
     * Space complexity: O(n)
     *
     * @param n
     * @return
     */
    public static int climbStairsRecursive(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
