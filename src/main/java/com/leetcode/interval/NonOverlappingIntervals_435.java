package com.leetcode.interval;

//        Given an array of intervals where intervals[i] = [starti, endi], return the minimum number of
//        intervals you need to remove to make the rest of the intervals non-overlapping.
//
//        Example 1:
//        Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
//        Output: 1
//        Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
//
//        Example 2:
//        Input: intervals = [[1,2],[1,2],[1,2]]
//        Output: 2
//        Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
//
//        Example 3:
//        Input: intervals = [[1,2],[2,3]]
//        Output: 0
//        Explanation: You don't need to remove any of the intervals since they're already non-overlapping.

import java.util.Arrays;

public class NonOverlappingIntervals_435 {

    public static void main(String[] args) {
        int[][] intervals = {{1, 100}, {11, 22}, {1, 11}, {2, 12}};
        int result = eraseOverlapIntervals(intervals);
        System.out.println("Result: " + result);
    }

    /**
     * Time complexity: O(n*logn)
     * Space complexity: O(1)
     *
     * @param intervals
     * @return
     */
    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0 || intervals == null) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int removed = 0;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prevEnd) {
                if (intervals[i][1] < prevEnd) {
                    removed++;
                    prevEnd = intervals[i][1];
                } else {
                    removed++;
                }
            } else {
                prevEnd = intervals[i][1];
            }
        }

        return removed;
    }
}
