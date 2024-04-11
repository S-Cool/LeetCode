package com.leetcode.array;

//        There is an integer array nums sorted in ascending order (with distinct values).
//
//        Prior to being passed to your function, nums is possibly rotated at an unknown pivot index
//        k (1 <= k < nums.length) such that the resulting
//        array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
//        For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
//
//        Given the array nums after the possible rotation and an integer target, return the index of target
//        if it is in nums, or -1 if it is not in nums.
//
//        You must write an algorithm with O(log n) runtime complexity.
//
//        Example 1:
//        Input: nums = [4,5,6,7,0,1,2], target = 0
//        Output: 4
//
//        Example 2:
//        Input: nums = [4,5,6,7,0,1,2], target = 3
//        Output: -1
//
//        Example 3:
//        Input: nums = [1], target = 0
//        Output: -1

public class SearchInRotatedSortedArray_33 {

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int result = search(nums, 0);
        int resultStepByStep = searchStepByStep(nums, 0);
        System.out.println("Result: " + result);
        System.out.println("Result step by step: " + resultStepByStep);
    }

    /**
     * Time complexity: O(log n)
     * Space complexity: O(1)
     *
     * @param nums - integer array sorted in ascending order
     * @param target - target integer
     * @return - the index of target
     *         if it is in nums, or -1 if it is not in nums
     */
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (target == nums[mid]) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {
                if (target > nums[mid] || target < nums[left]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (target < nums[mid] || target > nums[right]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    /**
     * Time complexity: O(log n)
     * Space complexity: O(1)
     *
     * @param nums - integer array sorted in ascending order
     * @param target - target integer
     * @return - the index of target
     *         if it is in nums, or -1 if it is not in nums
     */
    public static int searchStepByStep(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int minElementIndex = left;
        left = 0;
        right = nums.length - 1;

        if (target >= nums[minElementIndex] && target <= nums[right]) {
            left = minElementIndex;
        } else {
            right = minElementIndex;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
