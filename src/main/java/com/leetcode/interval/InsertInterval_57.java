package com.leetcode.interval;

//        You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi]
//        represent the start and the end of the ith interval and intervals is sorted in ascending order by
//        starti. You are also given an interval newInterval = [start, end] that represents the start and end of
//        another interval.
//
//        Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and
//        intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
//
//        Return intervals after the insertion.
//
//        Example 1:
//        Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
//        Output: [[1,5],[6,9]]
//
//        Example 2:
//        Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//        Output: [[1,2],[3,10],[12,16]]
//        Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval_57 {

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {3, 5},{6, 7}, {8, 10},{12, 16}};
        int[] newInterval = {4, 8};
        int[][] result = insert(intervals, newInterval);
        for (int[] res : result) {
            System.out.println("[" + res[0] + ", " + res[1] + "]");
        }
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * @param intervals
     * @param newInterval
     * @return
     */
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        // Insert the interval first before merge processing.
        intervals = insertInterval(intervals, newInterval);

        List<int[]> answer = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] currInterval = {intervals[i][0], intervals[i][1]};
            // Merge until the list gets exhausted or no overlap is found.
            while (i < intervals.length && doesIntervalsOverlap(currInterval, intervals[i])) {
                currInterval = mergeIntervals(currInterval, intervals[i]);
                i++;
            }
            // Decrement to ensure we don't skip the interval due to outer for-loop incrementing.
            i--;
            answer.add(currInterval);
        }

        return answer.toArray(new int[answer.size()][2]);
    }

    // Returns true if the intervals a and b have a common element.
    private static boolean doesIntervalsOverlap(int[] a, int[] b) {
        return Math.min(a[1], b[1]) - Math.max(a[0], b[0]) >= 0;
    }

    // Return the interval having all the elements of intervals a and b.
    private static int[] mergeIntervals(int[] a, int[] b) {
        return new int[]{Math.min(a[0], b[0]), Math.max(a[1], b[1])};
    }

    // Insert the interval newInterval, into the list interval keeping the sorting order intact.
    private static int[][] insertInterval(int[][] intervals, int[] newInterval) {
        boolean isIntervalInserted = false;
        List<int[]> list = new ArrayList<>(Arrays.asList(intervals));

        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[0] < intervals[i][0]) {
                // Found the position, insert the interval and break from the loop.
                list.add(i, newInterval);
                isIntervalInserted = true;
                break;
            }
        }

        // If there is no interval with a greater value of start value,
        // then the interval must be inserted at the end of the list.
        if (!isIntervalInserted) {
            list.add(newInterval);
        }

        return list.toArray(new int[list.size()][2]);
    }
}
