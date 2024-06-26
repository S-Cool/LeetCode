package com.leetcode.array;

//        Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
//
//        The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
//
//        You must write an algorithm that runs in O(n) time and without using the division operation.
//
//        Example 1:
//        Input: nums = [1,2,3,4]
//        Output: [24,12,8,6]
//
//        Example 2:
//        Input: nums = [-1,1,0,-3,3]
//        Output: [0,0,9,0,0]

import java.util.Arrays;

public class ProductOfArrayExceptSelf_238 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] result = productExceptSelf(nums);
        System.out.println("Result: " + Arrays.toString(result));
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * @param nums
     * @return
     */
    public static int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];
        int tmp = 1;

        for (int i = 0; i < nums.length; i++) {
            result[i] = tmp;
            tmp *= nums[i];
        }

        tmp = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= tmp;
            tmp *= nums[i];
        }

        return result;
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     *       nums = [1,2,3,4]
     *     prefix = [1,1,2,6]
     *    postfix = [24,12,4,1]
     *
     *      result = [24,12,8,6]
     *
     * @param nums
     * @return
     */
    public static int[] productExceptSelfEasyToUnderstand(int[] nums) {
        int[] result = new int[nums.length];
        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];

        prefix[0] = 1;
        postfix[nums.length - 1] = 1;

        for(int i = 1; i < nums.length; i++){
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        for(int j = nums.length - 2; j >= 0 ;j--){
            postfix[j] = postfix[j + 1] * nums[j + 1];
        }

        for(int k = 0; k < nums.length; k++){
            result[k] = prefix[k] * postfix[k];
        }

        return result;
    }
}
