package com.leetcode.matrix;

//        Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
//        You must do it in place.
//
//        Example 1:
//        Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
//        Output: [[1,0,1],[0,0,0],[1,0,1]]
//
//        Example 2:
//        Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
//        Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]

import java.util.ArrayList;
import java.util.List;

public class SetMatrixZeroes_73 {
    public static void main(String[] args) {
        int matrix[][] = {{1, 0, 1},
                {1, 0, 1},
                {1, 1, 1}};

        setZeroes(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Time complexity : O(m*n)
     * Space complexity : O(n)
     *
     * @param matrix
     */
    public static void setZeroes(int[][] matrix) {
        List<Integer> rows = new ArrayList<>();
        List<Integer> columns = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (rows.contains(i) || columns.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}