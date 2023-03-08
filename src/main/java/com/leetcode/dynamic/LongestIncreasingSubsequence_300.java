package com.leetcode.dynamic;

//        Given an integer array nums, return the length of the longest strictly increasing
//        subsequence.
//
//        Example 1:
//        Input: nums = [10,9,2,5,3,7,101,18]
//        Output: 4
//        Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
//
//        Example 2:
//        Input: nums = [0,1,0,3,2,3]
//        Output: 4
//
//        Example 3:
//        Input: nums = [7,7,7,7,7,7,7]
//        Output: 1

public class LongestIncreasingSubsequence_300 {

    public static void main(String[] args) {

        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int result = lengthOfLIS(nums);
        System.out.println("Result: " + result);
    }

    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;

        int result = 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;

        for (int i = 0; i < dp.length; i++) {
            int max = 0;

            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j]);
                }
                dp[i] = max + 1;
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
