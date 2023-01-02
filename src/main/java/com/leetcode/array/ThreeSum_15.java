package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//        Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such
//        that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
//
//        Notice that the solution set must not contain duplicate triplets.
//
//
//        Example 1:
//        Input: nums = [-1,0,1,2,-1,-4]
//        Output: [[-1,-1,2],[-1,0,1]]
//        Explanation:
//        nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
//        nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
//        nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
//        The distinct triplets are [-1,0,1] and [-1,-1,2].
//        Notice that the order of the output and the order of the triplets does not matter.
//
//        Example 2:
//        Input: nums = [0,1,1]
//        Output: []
//        Explanation: The only possible triplet does not sum up to 0.
//
//        Example 3:
//        Input: nums = [0,0,0]
//        Output: [[0,0,0]]
//        Explanation: The only possible triplet sums up to 0.

public class ThreeSum_15 {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(nums);
        System.out.println("Result: " + Arrays.toString(result.toArray()));
    }

    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(n)
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (right > left) {
                int threeSum = nums[i] + nums[left] + nums[right];
                if (threeSum > 0) {
                    right -= 1;
                } else if (threeSum < 0) {
                    left += 1;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left += 1;
                    while (nums[left] == nums[left - 1] && left < right) {
                        left += 1;
                    }
                }
            }
        }

        return result;
    }
}
