package com.leetcode.matrix;

//        You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
//
//        You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
//        DO NOT allocate another 2D matrix and do the rotation.
//
//        Example 1:
//        Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//        Output: [[7,4,1],[8,5,2],[9,6,3]]
//
//        Example 2:
//        Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//        Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

public class RotateImage_48 {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        printMatrix(matrix);

        rotate(matrix);
        System.out.println("\nAfter rotation:");
        printMatrix(matrix);
        System.out.println("\nAfter second rotation:");
        rotateDiagonal(matrix);
        printMatrix(matrix);
    }

    /**
     * Time complexity : O(m)
     * Space complexity : O(1)
     *
     * @param matrix
     */
    public static void rotate(int[][] matrix) {
        int mLength = matrix.length;
        for (int i = 0; i < (mLength + 1) / 2; i++) {
            for (int j = 0; j < mLength / 2; j++) {
                int temp = matrix[mLength - 1 - j][i];
                matrix[mLength - 1 - j][i] = matrix[mLength - 1 - i][mLength - j - 1];
                matrix[mLength - 1 - i][mLength - j - 1] = matrix[j][mLength - 1 - i];
                matrix[j][mLength - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }

    /**
     * Time complexity : O(m)
     * Space complexity : O(1)
     *
     * @param matrix
     */
    public static void rotateDiagonal(int[][] matrix) {
        transpose(matrix);
        reflect(matrix);
    }

    private static void transpose(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
    }

    private static void reflect(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
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
