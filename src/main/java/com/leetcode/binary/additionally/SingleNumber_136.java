package com.leetcode.binary.additionally;


//Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
//You must implement a solution with a linear runtime complexity and use only constant extra space.
//
//        Example 1:
//        Input: nums = [2,2,1]
//        Output: 1
//
//        Example 2:
//        Input: nums = [4,1,2,1,2]
//        Output: 4
//
//        Example 3:
//        Input: nums = [1]
//        Output: 1

public class SingleNumber_136 {

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        int result = singleNumber(nums);
        System.out.println("Result:" + result);
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        int result = nums[0];
        for(int i = 1; i < nums.length; i++){
            result = nums[i] ^ result;
        }
        return result;
    }
}
