package com.leetcode.graph;

//        Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
//        You must write an algorithm that runs in O(n) time.
//
//        Example 1:
//        Input: nums = [100,4,200,1,3,2]
//        Output: 4
//        Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
//
//        Example 2:
//        Input: nums = [0,3,7,2,5,8,4,6,0,1]
//        Output: 9

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence_128 {

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        int result = longestConsecutive(nums);
        System.out.println("Result: " + result);

        int consecutiveTwo = longestConsecutiveTwo(nums);
        System.out.println("Result: " + consecutiveTwo);
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * @param nums
     * @return
     */
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        Integer[] uniqueNums = set.toArray(new Integer[0]);

        int longest = 0;

        for (int i = 0; i < uniqueNums.length; i++) {
            if (!set.contains(uniqueNums[i] - 1)) {
                int length = 0;

                while (set.contains(uniqueNums[i] + length)) {
                    length++;
                    longest = Math.max(length, longest);
                }
            }
        }
        return longest;
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * @param nums
     * @return
     */
    public static int longestConsecutiveTwo(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();

        for (int num : nums) set.add(num);
        int max = 1;

        for (int num : nums) {
            if (set.remove(num)) {
                int sum = 1;

                int val = num;
                while (set.remove(val - 1)) {
                    val--;
                }
                sum += num - val;

                val = num;
                while (set.remove(val + 1)) {
                    val++;
                }
                sum += val - num;

                max = Math.max(max, sum);
            }
        }
        return max;
    }
}
