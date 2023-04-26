package com.leetcode.graph;

//        You have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [ai, bi]
//        indicates that there is an edge between ai and bi in the graph.
//
//        Return the number of connected components in the graph.
//
//        Example1:
//        Input: n = 5, edges = [[0,1],[1,2],[3,4]]
//        Output: 2

import java.util.HashSet;
import java.util.Set;

public class NumberOfConnectedComponentsInAnUndirectedGraph_323 {

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        int result = countComponents(5, edges);
        System.out.println("Result: " + result);
    }


    /**
     * Union Find
     * Time complexity: O(n + m*log(n))
     * Space complexity: O(n)
     *
     * @param n
     * @param edges
     * @return
     */
    public static int countComponents(int n, int[][] edges) {
        int[] ids = new int[n];

        for (int i = 0; i < ids.length; i++) {
            ids[i] = i;
        }

        for (int[] edge : edges) {
            union(edge[0], edge[1], ids);
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < ids.length; i++) {
            set.add(find(ids[i], ids));
        }
        return set.size();
    }

    private static void union(int edge1, int edge2, int[] ids) {
        int parent1 = find(edge1, ids);
        int parent2 = find(edge2, ids);
        ids[parent1] = parent2;
    }

    private static int find(int edge, int[] ids) {
        if (ids[edge] != edge) {
            ids[edge] = find(ids[edge], ids);
        }
        return ids[edge];
    }
}
