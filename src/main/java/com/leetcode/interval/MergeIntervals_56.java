package com.leetcode.interval;

//        Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
//        and return an array of the non-overlapping intervals that cover all the intervals in the input.
//
//        Example 1:
//        Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//        Output: [[1,6],[8,10],[15,18]]
//        Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
//
//        Example 2:
//        Input: intervals = [[1,4],[4,5]]
//        Output: [[1,5]]
//        Explanation: Intervals [1,4] and [4,5] are considered overlapping.

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals_56 {

    public static void main(String[] args) {
        int[][] intervals = {{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}};
        int[][] result = merge(intervals);
        for (int[] res : result) {
            System.out.println("[" + res[0] + ", " + res[1] + "]");
        }
    }

    /**
     * Time complexity: O(n*logn)
     * Space complexity: O(n)
     *
     * @param intervals
     * @return
     */
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        merged.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            if (merged.getLast()[1] < intervals[i][0]) {
                merged.add(intervals[i]);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], intervals[i][1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
