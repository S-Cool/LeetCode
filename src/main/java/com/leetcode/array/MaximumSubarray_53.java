package com.leetcode.array;

//        Given an integer array nums, find the subarray which has the largest sum and return its sum.
//
//        Example 1:
//        Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//        Output: 6
//        Explanation: [4,-1,2,1] has the largest sum = 6.
//
//        Example 2:
//        Input: nums = [1]
//        Output: 1
//
//        Example 3:
//        Input: nums = [5,4,-1,7,8]
//        Output: 23

public class MaximumSubarray_53 {
    public static void main(String[] args) {
        int[] array = {-2,1,-3,4,-1,2,1,-5,4};
        int maxSubArray = maxSubArray(array);
        System.out.println("Result: " + maxSubArray);
    }

    /**
     * Time complexity O(n) / Space complexity O(1)
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            max = Math.max(sum, max);

            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }

    /**
     * Brute Force variant
     * Time complexity O(n^2) / Space complexity O(1)
     *
     * @param inputArray
     * @return
     */
    public static int findMaxSum(int[] inputArray) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < inputArray.length; i++) {
            sum = 0;
            for (int j = i; j < inputArray.length; j++) {
                sum += inputArray[j];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }
}
