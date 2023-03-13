package com.leetcode.dynamic;

//        Given an array of distinct integers nums and a target integer target, return the number of possible
//        combinations that add up to target.
//
//        The test cases are generated so that the answer can fit in a 32-bit integer.
//
//        Example 1:
//        Input: nums = [1,2,3], target = 4
//        Output: 7
//        Explanation:
//        The possible combination ways are:
//        (1, 1, 1, 1)
//        (1, 1, 2)
//        (1, 2, 1)
//        (1, 3)
//        (2, 1, 1)
//        (2, 2)
//        (3, 1)
//        Note that different sequences are counted as different combinations.
//
//        Example 2:
//        Input: nums = [9], target = 3
//        Output: 0

public class CombinationSumIV_377 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int result = combinationSum4(nums, 4);
        System.out.println("Result: " + result);

        int combinationSum = combinationSum(nums, 4);
        System.out.println("Result: " + combinationSum);
    }

    /**
     * Buttom-Up
     * <p>
     * Time complexity: O(m*n)
     * Space complexity: O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i < target; i++) {
            if (dp[i] == 0) continue;
            for (int num : nums)
                if (num + i <= target) {
                    dp[i + num] += dp[i];
                }
        }
        return dp[target];
    }

    /**
     * Top-Down
     * <p>
     * Time complexity: O(m*n)
     * Space complexity: O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int combinationSum(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
