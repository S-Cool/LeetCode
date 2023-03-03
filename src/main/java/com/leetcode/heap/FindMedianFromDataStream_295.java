package com.leetcode.heap;

//        The median is the middle value in an ordered integer list. If the size of the list is even,
//        there is no middle value, and the median is the mean of the two middle values.
//
//        For example, for arr = [2,3,4], the median is 3.
//        For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
//        Implement the MedianFinder class:
//
//        MedianFinder() initializes the MedianFinder object.
//        void addNum(int num) adds the integer num from the data stream to the data structure.
//        double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer
//        will be accepted.
//
//        Example 1:
//        Input
//        ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
//        [[], [1], [2], [], [3], []]
//        Output
//        [null, null, null, 1.5, null, 2.0]
//        Explanation
//        MedianFinder medianFinder = new MedianFinder();
//        medianFinder.addNum(1);    // arr = [1]
//        medianFinder.addNum(2);    // arr = [1, 2]
//        medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
//        medianFinder.addNum(3);    // arr[1, 2, 3]
//        medianFinder.findMedian(); // return 2.0

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream_295 {

    public static void main(String[] args) {
        FindMedianFromDataStream_295 stream = new FindMedianFromDataStream_295();
        stream.addNum(3);
        stream.addNum(2);
        stream.addNum(7);
        stream.addNum(4);
        double median = stream.findMedian();
        System.out.println("Result: " + median);
    }

    private final PriorityQueue<Integer> left;
    private final PriorityQueue<Integer> right;
    private boolean even = true;

    public FindMedianFromDataStream_295() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (even) {
            right.offer(num);
            left.offer(right.poll());
        } else {
            left.offer(num);
            right.offer(left.poll());
        }
        even = !even;
    }

    public double findMedian() {
        if (even)
            return (left.peek() + right.peek()) / 2.0;
        else
            return left.peek();
    }
}
