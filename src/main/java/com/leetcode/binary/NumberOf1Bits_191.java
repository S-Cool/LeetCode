package com.leetcode.binary;

//        Write a function that takes the binary representation of an unsigned integer and returns the number
//        of '1' bits it has (also known as the Hamming weight).
//
//        Note:
//        Note that in some languages, such as Java, there is no unsigned integer type. In this case, the input
//        will be given as a signed integer type. It should not affect your implementation, as the integer's
//        nternal binary representation is the same, whether it is signed or unsigned.
//        In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3,
//        the input represents the signed integer. -3.
//
//        Example 1:
//        Input: n = 00000000000000000000000000001011
//        Output: 3
//        Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
//
//        Example 2:
//        Input: n = 00000000000000000000000010000000
//        Output: 1
//        Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.
//
//        Example 3:
//        Input: n = 11111111111111111111111111111101
//        Output: 31
//        Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.

public class NumberOf1Bits_191 {

    public static void main(String[] args) {
        int n = 11;
        int result = hammingWeight(n);
        System.out.println("Result: " + result);

        int approach2 = hammingWeightApproach2(n);
        System.out.println("Result Approach 2: " + approach2);
    }

    /**
     * Time complexity: O(1)
     * Space complexity: O(1)
     *
     * @param n
     * @return
     */
    public static int hammingWeight(int n) {
        int count = 0;
        int mask = 1;

        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                count++;
            }
            mask = mask << 1;
        }
        return count;
    }

    /**
     * Time complexity: O(1)
     * Space complexity: O(1)
     *
     * @param n
     * @return
     */
    public static int hammingWeightApproach2(int n) {
        int count = 0;

        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}
