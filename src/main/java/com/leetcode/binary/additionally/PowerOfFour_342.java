package com.leetcode.binary.additionally;

//Given an integer n, return true if it is a power of four. Otherwise, return false.
//An integer n is a power of four, if there exists an integer x such that n == 4x.
//
//        Example 1:
//        Input: n = 16
//        Output: true
//
//        Example 2:
//        Input: n = 5
//        Output: false
//
//        Example 3:
//        Input: n = 1
//        Output: true

public class PowerOfFour_342 {

    public static void main(String[] args) {
        boolean result = isPowerOfFour(16);
        System.out.println("Result: " + result);
        boolean powerOfFour = isPowerOfFourMoreReadable(16);
        System.out.println("Result: " + powerOfFour);
    }

    /**
     * Time complexity: O(1)
     * Space complexity: O(1)
     *
     * @param n - input value
     * @return true if input value power of four and false if not
     */
    public static boolean isPowerOfFour(int n) {
        // If 'n' is less than or equal to 0 or not a power of two, return false
        if (n <= 0 || (n & (n - 1)) != 0) {
            return false;
        }

        // 0x55555555 in binary is 01010101010101010101010101010101.
        // This pattern represents having bits set at odd positions.
        return (n & 0x55555555) != 0;
    }

    public static boolean isPowerOfFourMoreReadable(int n){
        if (n <= 0 || (n & (n - 1)) != 0) {
            return false;
        }

        int count = 0;

        while (n > 1) {
            n >>= 1;
            count++;
        }

        return count % 2 == 0;
    }
}
