package com.leetcode.matrix;

//        Given an m x n matrix, return all elements of the matrix in spiral order.
//
//        Example 1:
//        Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//        Output: [1,2,3,6,9,8,7,4,5]
//
//        Example 2:
//        Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//        Output: [1,2,3,4,8,12,11,10,9,5,6,7]

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix_54 {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        List<Integer> spiralOrder = spiralOrder(matrix);
        System.out.println("Result: " + spiralOrder);
    }

    /**
     * Time complexity : O(m*n)
     * Space complexity : O(n)
     *
     * @param matrix
     * @return
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new LinkedList<>();

        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;

        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            if (left <= right && top <= bottom) {
                for (int i = right; left <= i; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;

                for (int i = bottom; top <= i; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }
}
