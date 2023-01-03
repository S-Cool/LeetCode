package com.leetcode.array;

//        You are given an integer array height of length n. There are n vertical lines drawn such that the
//        two endpoints of the ith line are (i, 0) and (i, height[i]).
//
//        Find two lines that together with the x-axis form a container, such that the container contains
//        the most water.
//
//        Return the maximum amount of water a container can store.
//
//        Notice that you may not slant the container.
//
//        Example 1:
//        Input: height = [1,8,6,2,5,4,8,3,7]
//        Output: 49
//        Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case,
//        the max area of water (blue section) the container can contain is 49.
//
//        Example 2:
//        Input: height = [1,1]
//        Output: 1

public class ContainerWithMostWater_11 {

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = maxAreaTwoPointer(height);
        System.out.println("Result: " + result);
    }

    /**
     * Brute Force
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        if (height.length < 2) {
            return 0;
        }

        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = Math.min(height[i], height[j]) * (j - i);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }

        return maxArea;
    }

    /**
     * Two Pointer Approach
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param height
     * @return
     */
    public static int maxAreaTwoPointer(int[] height) {
        if (height.length < 2) {
            return 0;
        }

        int maxArea = Integer.MIN_VALUE;
        int left = 0;
        int right = height.length - 1;
        while (right > left) {
            int minHeight = Math.min(height[left], height[right]);
            int weight = right - left;
            int area = minHeight * weight;
            maxArea = Math.max(maxArea, area);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }

        return maxArea;
    }
}
