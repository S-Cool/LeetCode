package com.leetcode.matrix;

//        Given an m x n grid of characters board and a string word, return true if word exists in the grid.
//
//        The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are
//        horizontally or vertically neighboring. The same letter cell may not be used more than once.
//
//        Example 1:
//        Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
//        Output: true
//
//        Example 2:
//        Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
//        Output: true
//
//        Example 3:
//        Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
//        Output: false

public class WordSearch_79 {

    public static void main(String[] args) {
        char[][] matrix = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        boolean exist = exist(matrix, word);
        System.out.println("Result: " + exist);
    }

    public static boolean exist(char[][] board, String word) {
        /*Find word's first letter. Then call method to check its surroundings */
        for (int rows = 0; rows < board.length; rows++) {
            for (int columns = 0; columns < board[0].length; columns++) {
                if (board[rows][columns] == word.charAt(0) && help(board, word, 0, rows, columns)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean help(char[][] board, String word, int start, int rows, int columns) {
        /* once we get past word.length, we are done. */
        if (word.length() <= start)
            return true;

        /* if off bounds, letter is seen, letter is unequal to word.charAt(start) return false */
        if (rows < 0 || columns < 0 ||
                rows >= board.length || columns >= board[0].length ||
                board[rows][columns] == '0' || board[rows][columns] != word.charAt(start)) {
            return false;
        }

        /* set this board position to have seen. (Because we can use this position) */
        char tmp = board[rows][columns];
        board[rows][columns] = '0';

        /* recursion on all 4 sides for next letter, if works: return true */
        if (help(board, word, start + 1, rows + 1, columns) ||
                help(board, word, start + 1, rows - 1, columns) ||
                help(board, word, start + 1, rows, columns + 1) ||
                help(board, word, start + 1, rows, columns - 1)) {
            return true;
        }

        //Set back to unseen
        board[rows][columns] = tmp;

        return false;
    }
}
