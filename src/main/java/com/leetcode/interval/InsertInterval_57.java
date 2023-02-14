package com.leetcode.interval;

//        You are given an array of non-overlapping intervals where intervals[i] = [starti, endi]
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
import java.util.LinkedList;
import java.util.List;

public class InsertInterval_57 {

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
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
        intervals = insertInterval(intervals, newInterval);

        LinkedList<int[]> answer = new LinkedList<>();
        for (int[] interval : intervals) {
            if (answer.isEmpty() || answer.getLast()[1] < interval[0]) {
                answer.add(interval);
            } else {
                answer.getLast()[1] = Math.max(answer.getLast()[1], interval[1]);
            }
        }

        return answer.toArray(new int[answer.size()][]);
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
