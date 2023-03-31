package com.leetcode.binary;

//        Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that
//        is missing from the array.
//
//        Example 1:
//        Input: nums = [3,0,1]
//        Output: 2
//        Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number
//        in the range since it does not appear in nums.
//
//        Example 2:
//        Input: nums = [0,1]
//        Output: 2
//        Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number
//        in the range since it does not appear in nums.
//
//        Example 3:
//        Input: nums = [9,6,4,2,3,5,7,0,1]
//        Output: 8
//        Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number
//        in the range since it does not appear in nums.

public class MissingNumber_268 {

    public static void main(String[] args) {
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        int result = missingNumber(nums);
        System.out.println("Result: " + result);

        int missingNumberXOR = missingNumberXOR(nums);
        System.out.println("Result: " + missingNumberXOR);
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * @param nums
     * @return
     */
    public static int missingNumber(int[] nums) {
        Integer[] dp = new Integer[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            dp[nums[i]] = i;
        }

        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == null) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * @param nums
     * @return
     */
    public static int missingNumberXOR(int[] nums) {
        int result = nums.length;
        for (int i = 0; i < nums.length; i++) {
            result ^= i;
            result ^= nums[i];
        }
        return result;
    }
}
