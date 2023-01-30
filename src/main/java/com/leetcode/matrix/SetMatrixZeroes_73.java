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
        int[][] matrix = {{1, 0, 1},
                {1, 0, 1},
                {1, 1, 1}};

        int[][] matrixSecond = {{1, 0, 1},
                {1, 0, 1},
                {1, 1, 1}};

        setZeroes(matrix);

        printMatrix(matrix);

        setZeroesSpaceEfficient(matrixSecond);

        printMatrix(matrixSecond);
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

    /**
     * Time complexity : O(m*n)
     * Space complexity : O(1)
     *
     * @param matrix
     */
    public static void setZeroesSpaceEfficient(int[][] matrix) {
        boolean isCol = false;
        int rowLength = matrix.length;
        int columnLength = matrix[0].length;

        for (int i = 0; i < rowLength; i++) {
            if (matrix[i][0] == 0) {
                isCol = true;
            }
            for (int j = 1; j < columnLength; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < rowLength; i++) {
            for (int j = 1; j < columnLength; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // See if the first row needs to be set to zero as well
        if (matrix[0][0] == 0) {
            for (int j = 0; j < columnLength; j++) {
                matrix[0][j] = 0;
            }
        }

        // See if the first column needs to be set to zero as well
        if (isCol) {
            for (int i = 0; i < rowLength; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}