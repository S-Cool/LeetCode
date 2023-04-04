package com.leetcode.graph;

//        Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water), return the number
//        of islands.
//
//        An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
//        You may assume all four edges of the grid are all surrounded by water.
//
//        Example 1:
//        Input: grid = [
//        ["1","1","1","1","0"],
//        ["1","1","0","1","0"],
//        ["1","1","0","0","0"],
//        ["0","0","0","0","0"]
//        ]
//        Output: 1
//
//        Example 2:
//        Input: grid = [
//        ["1","1","0","0","0"],
//        ["1","1","0","0","0"],
//        ["0","0","1","0","0"],
//        ["0","0","0","1","1"]
//        ]
//        Output: 3

public class NumberOfIslands_200 {

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0' },
                {'1', '1', '0', '0', '0' },
                {'0', '0', '1', '0', '0' },
                {'0', '0', '0', '1', '1' }
        };

        int result = numIslands(grid);
        System.out.println("Result: " + result);
    }

    /**
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     *
     * @param grid
     * @return
     */
    public static int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        int islands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    clearRestOfLand(grid, i, j);
                    islands++;
                }
            }
        }

        return islands;
    }

    private static void clearRestOfLand(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';
        clearRestOfLand(grid, i + 1, j);
        clearRestOfLand(grid, i - 1, j);
        clearRestOfLand(grid, i, j + 1);
        clearRestOfLand(grid, i, j - 1);
    }
}
