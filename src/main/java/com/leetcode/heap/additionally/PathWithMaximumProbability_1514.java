package com.leetcode.heap.additionally;

//You are given an undirected weighted graph of n nodes (0-indexed), represented by an edge list where edges[i] = [a, b]
//is an undirected edge connecting the nodes a and b with a probability of success of traversing that edge succProb[i].
//
//Given two nodes start and end, find the path with the maximum probability of success to go from start to end and
//return its success probability.
//
//If there is no path from start to end, return 0. Your answer will be accepted if it differs from the correct
//answer by at most 1e-5.
//
//        Example 1:
//        Input: n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5, 0.5, 0.2], start = 0, end = 2
//        Output: 0.25000
//        Explanation: There are two paths from start to end, one having a probability of success = 0.2
//        and the other has 0.5 * 0.5 = 0.25.
//
//             (0)
//       0.5   / \    0.2
//           (1)--(2)
//              0.5
//
//        Example 2:
//        Input: n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5, 0.5, 0.3], start = 0, end = 2
//        Output: 0.30000
//
//              (0)
//        0.5   / \    0.3
//            (1)--(2)
//               0.5
//
//        Example 3:
//        Input: n = 3, edges = [[0,1]], succProb = [0.5], start = 0, end = 2
//        Output: 0.00000
//        Explanation: There is no path between 0 and 2.
//
//              (0)
//        0.5   /
//            (1)  (2)
//
//         Dijkstra's algorithm

import java.util.*;

public class PathWithMaximumProbability_1514 {
    public static void main(String[] args) {
        int n = 5;
        int startNode = 0;
        int endNode = 3;
        int[][] edges = {{0, 1}, {1, 2}, {0, 2}};
//        int[][] edges = {{2,3},{1,2},{3,4},{1,3},{1,4},{0,1},{2,4},{0,4},{0,2}};
        double[] succProb = {0.5, 0.5, 0.2};
//        double[] succProb = {0.06,0.26,0.49,0.25,0.2,0.64,0.23,0.21,0.77};

        PathWithMaximumProbability_1514 probability1514 = new PathWithMaximumProbability_1514();
        double result = probability1514.maxProbability(n, edges, succProb, startNode, endNode);
        System.out.println("Result: = " + result);
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        if (succProb.length !=  edges.length) {
            return 0;
        }

        Map<Integer, List<Pair>> mapEdgeProbability = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            int currentStartEdge = edges[i][0];
            int currentEndEdge = edges[i][1];
            double currentProbability = succProb[i];


            Set<Integer> visitedSet = new HashSet<>();

            Pair pair = new Pair(currentEndEdge, currentProbability);
            List<Pair> pairs;
            if (!visitedSet.contains(pair.edge)) {
                if (!mapEdgeProbability.containsKey(currentStartEdge)) {
                    pairs = new ArrayList<>();
                    pairs.add(pair);
                } else {
                    pairs = mapEdgeProbability.get(currentStartEdge);
                    pairs.add(pair);
                }
                mapEdgeProbability.put(currentStartEdge, pairs);
                visitedSet.add(pair.edge);
            }
        }

        PriorityQueue<Pair> pairPriorityQueue =
                new PriorityQueue<>(Comparator.<Pair>comparingDouble(p -> p.probability).reversed());

        List<Pair> pairs = mapEdgeProbability.get(start_node);
        for (Pair pair : pairs) {
            pairPriorityQueue.offer(pair);
        }


        while (!pairPriorityQueue.isEmpty() && pairPriorityQueue.peek().edge != end_node) {
            Pair value = pairPriorityQueue.peek();
            int searchEdge = value.edge;
            boolean searchPathEdgeExist = mapEdgeProbability.containsKey(searchEdge);
            if (searchPathEdgeExist){
                List<Pair> pairsForNextIteration = mapEdgeProbability.get(searchEdge);
                for (Pair pair : pairsForNextIteration){
                        double multipliedProbability = value.probability * pair.probability;
                        pairPriorityQueue.offer(new Pair(pair.edge, multipliedProbability));
                }
                pairPriorityQueue.remove(value);
            } else {
                break;
            }
        }

        Pair pair = pairPriorityQueue.peek();
        System.out.println("Pair[" + pair.edge + ", " + pair.probability + "]");
        return pairPriorityQueue.isEmpty() ? 0 : pair.probability;
    }

    public class Pair {
        private final int edge;
        private final double probability;

        public Pair(int edges, double probability) {
            this.edge = edges;
            this.probability = probability;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return edge == pair.edge && Double.compare(pair.probability, probability) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(edge, probability);
        }
    }
}
