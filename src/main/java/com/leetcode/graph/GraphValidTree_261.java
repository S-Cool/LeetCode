package com.leetcode.graph;

//        Given n nodes labeled from 0 to n - 1 and a list of indirected edges (each edge is a pair of nodes),
//        write a function to check whether these edges make up a valid tree.
//
//        You can assume that no duplicate edges will appear in edges. Since all edges are undirected , [0, 1] is
//        the same as [1, 0] and thus will not appear together in edge.
//
//        Example1:
//        Input: n = 5 edges = [[0, 1], [0, 2], [0, 3], [1, 4]]
//        Output: true
//
//        Example2:
//        Input: n = 5 edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]]
//        Output: false

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GraphValidTree_261 {

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        int[][] edgesFalse = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
        boolean result = validTree(5, edges);
        boolean validTreeFalse = validTree(5, edgesFalse);
        System.out.println("Result: " + result);
        System.out.println("Result: " + validTreeFalse);
    }

    private static final List<List<Integer>> adjList = new ArrayList<>();
    private static final Set<Integer> visited = new HashSet<>();

    private static boolean validTree(int n, int[][] edges) {
        if (n == 0) return true;
        if (edges.length != n - 1) return false;
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        boolean noCycle = dfs(0);
        return noCycle && visited.size() == n;
    }

    private static boolean dfs(int curNode) {
        if (visited.contains(curNode)) return false;

        visited.add(curNode);

        for (int neighbour : adjList.get(curNode)) {
            dfs(neighbour);
        }
        return true;
    }
}

