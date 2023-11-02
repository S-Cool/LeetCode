package com.leetcode.array.additionally;

//Given an array nums of size n, return the majority element.
//
//The majority element is the element that appears more than ⌊n / 2⌋ times.
//You may assume that the majority element always exists in the array.
//
//        Example 1:
//        Input: nums = [3,2,3]
//        Output: 3
//
//        Example 2:
//        Input: nums = [2,2,1,1,1,2,2]
//        Output: 2

import java.util.HashMap;
import java.util.Map;

public class MajorityElement_169 {

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        int result = majorityElement(nums);
        int resultMoore = majorityElementMooreVotingAlgorithm(nums);
        System.out.println("Result: " + result);
        System.out.println("Boyer–Moore Majority Vote Algorithm: " + resultMoore);
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param nums - array nums
     * @return - the majority element
     */
    public static int majorityElement(int[] nums) {
        int result = nums[0];
        int max = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                int value = map.get(num) + 1;
                map.put(num, value);
                if (value > max) {
                    max = value;
                    result = num;
                }
            } else {
                map.put(num, 1);
            }
        }
        return result;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * <a href="https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm">Boyer–Moore algorithm</a>
     *
     * @param nums
     * @return
     */
    public static int majorityElementMooreVotingAlgorithm(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }
}
