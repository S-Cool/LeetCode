package com.leetcode.graph;

//        There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
//        You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take
//        course bi first if you want to take course ai.
//
//        For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
//        Return true if you can finish all courses. Otherwise, return false.
//
//        Example 1:
//        Input: numCourses = 2, prerequisites = [[1,0]]
//        Output: true
//        Explanation: There are a total of 2 courses to take.
//        To take course 1 you should have finished course 0. So it is possible.
//
//        Example 2:
//        Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
//        Output: false
//        Explanation: There are a total of 2 courses to take.
//        To take course 1 you should have finished course 0, and to take course 0 you should also have finished
//        course 1. So it is impossible.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule_207 {

    public static void main(String[] args) {
        boolean positiveResult = canFinish(5, new int[][]{{0, 1}, {0, 2}, {1, 3}, {1, 4}, {3, 4}});
        System.out.println("Positive Result: " + positiveResult);

        boolean negativeResult = canFinish(2, new int[][]{{0, 1}, {1, 0}});
        System.out.println("Negative Result: " + negativeResult);
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> dependency = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            dependency.put(i, new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            dependency.get(pre[0]).add(pre[1]);
        }

        // Define an array of visited (0 -> unvisited, 1 -> visited, 2 -> completed), initially filled with 0's
        int[] visited = new int[numCourses];

        // Do DFS for each of the array nodes to check a cycle
        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, visited, dependency)) {
                return false;
            }
        }

        return true;
    }

    private static boolean dfs(int indexNode, int[] visited, Map<Integer, List<Integer>> graph) {
        // Return false if the node is visited and viewed again before completion
        if (visited[indexNode] == 1) {
            return true;
        }

        // Return true if the node is completed processing
        if (visited[indexNode] == 2) {
            return false;
        }

        // Mark the node as visited
        visited[indexNode] = 1;

        // DFS of all the other nodes current "node" is connected to
        for (int dependencyIndex : graph.get(indexNode)) {
            if (dfs(dependencyIndex, visited, graph)) {
                return true;
            }
        }

        // If no more other nodes for the current "node" mark as completed and return true
        visited[indexNode] = 2;

        return false;
    }
}
