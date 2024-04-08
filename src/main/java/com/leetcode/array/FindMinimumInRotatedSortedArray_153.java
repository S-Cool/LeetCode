package com.leetcode.array;

//        Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example,
//        the array nums = [0,1,2,4,5,6,7] might become:
//
//        [4,5,6,7,0,1,2] if it was rotated 4 times.
//        [0,1,2,4,5,6,7] if it was rotated 7 times.
//
//        Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in
//        the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
//
//        Given the sorted rotated array nums of unique elements, return the minimum element of this array.
//
//        You must write an algorithm that runs in O(log n) time.
//
//        Example 1:
//        Input: nums = [3,4,5,1,2]
//        Output: 1
//        Explanation: The original array was [1,2,3,4,5] rotated 3 times.
//
//        Example 2:
//        Input: nums = [4,5,6,7,0,1,2]
//        Output: 0
//        Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
//
//        Example 3:
//        Input: nums = [11,13,15,17]
//        Output: 11
//        Explanation: The original array was [11,13,15,17] and it was rotated 4 times.

public class FindMinimumInRotatedSortedArray_153 {

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        int min = findMin(nums);
        System.out.println("Result: " + min);
    }

    /**
     * Time Complexity: O(logN)
     * Space Complexity: O(1)
     *
     * @param nums
     * @return
     */
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // Perform binary search until the search space is reduced to a single element
        while (left < right) {
            int mid = left + (right - left) / 2; // Calculate the middle index

            // If the middle element is greater than the rightmost element,
            // the minimum element must be in the right half of the array
            if (nums[mid] > nums[right]) {
                left = mid + 1; // Update the left boundary to mid + 1
            } else {
                // Otherwise, the minimum element is in the left half of the array
                // or it might be the mid element itself, so update the right boundary to mid
                right = mid;
            }
        }

        // At the end of the loop, left and right pointers converge to the minimum element
        // which is stored at index left or right (they are equal)
        return nums[left];
    }
}
