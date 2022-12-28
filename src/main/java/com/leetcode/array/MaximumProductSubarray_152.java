package com.leetcode.array;

//        Given an integer array nums, find a subarray that has the largest product, and return the product.
//
//        The test cases are generated so that the answer will fit in a 32-bit integer.
//
//        Example 1:
//        Input: nums = [2,3,-2,4]
//        Output: 6
//        Explanation: [2,3] has the largest product 6.
//
//        Example 2:
//        Input: nums = [-2,0,-1]
//        Output: 0
//        Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

public class MaximumProductSubarray_152 {

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        int result = maxProduct(nums);
        System.out.println("Result: " + result);
    }

    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int temp = 1;

        for (int num : nums) {
            temp = temp * num;
            max = Math.max(max, temp);
            if (num == 0) {
                temp = 1;
            }
        }

        temp = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            temp = temp * nums[i];
            max = Math.max(max, temp);
            if (nums[i] == 0) {
                temp = 1;
            }
        }
        return max;
    }
}
