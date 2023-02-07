package com.leetcode.graph;

import java.util.*;

//        Given a reference of a node in a connected undirected graph.
//        Return a deep copy (clone) of the graph.
//        Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
//
//        Test case format:
//        For simplicity, each node's value is the same as the node's index (1-indexed). For example, the first
//        node with val == 1, the second node with val == 2, and so on. The graph is represented in the
//        test case using an adjacency list.
//
//        An adjacency list is a collection of unordered lists used to represent a finite graph. Each list
//        describes the set of neighbors of a node in the graph.
//
//        The given node will always be the first node with val = 1. You must return the copy of the given
//        node as a reference to the cloned graph.
//
//        Example 1:
//        Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
//        Output: [[2,4],[1,3],[2,4],[1,3]]
//        Explanation: There are 4 nodes in the graph.
//        1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
//        2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
//        3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
//        4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
//
//        Example 2:
//        Input: adjList = [[]]
//        Output: [[]]
//        Explanation: Note that the input contains one empty list. The graph consists of only one node with
//        val = 1 and it does not have any neighbors.

public class CloneGraph_133 {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        CloneGraph_133 graph = new CloneGraph_133();
        System.out.println("Initial Graph:");
        printGraph(node1);

        Node cloneGraphRecursive = graph.cloneGraphRecursive(node1);
        System.out.println("\nCloned Recursive Graph:");
        printGraph(cloneGraphRecursive);

        Node cloneGraphIterative = graph.cloneGraphIterative(node1);
        System.out.println("\nCloned Iterative Graph:");
        printGraph(cloneGraphIterative);
    }

    private Map<Integer, Node> map = new HashMap<>();

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * @param node
     * @return
     */
    public Node cloneGraphRecursive(Node node) {
        return clone(node);
    }

    private Node clone(Node node) {
        if (node == null) return null;

        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }

        Node clone = new Node(node.val);
        map.put(clone.val, clone);

        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(clone(neighbor));
        }

        return clone;
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * @param node
     * @return
     */
    public Node cloneGraphIterative(Node node) {
        if (node == null) {
            return null;
        }

        Node cloneNode = new Node(node.val);

        Map<Integer, Node> nodeHashMap = new HashMap<>();
        nodeHashMap.put(cloneNode.val, cloneNode);

        Deque<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node n = queue.pop();
            for (Node neighbor : n.neighbors) {
                if (!nodeHashMap.containsKey(neighbor.val)) {
                    nodeHashMap.put(neighbor.val, new Node(neighbor.val));
                    queue.add(neighbor);
                }
                nodeHashMap.get(n.val).neighbors.add(nodeHashMap.get(neighbor.val));
            }
        }
        return cloneNode;
    }

    private static void printGraph(Node node) {
        if (node != null) {
            Node cloneNode = new Node(node.val);

            Map<Integer, Node> nodeHashMap = new HashMap<>();
            nodeHashMap.put(cloneNode.val, cloneNode);

            Deque<Node> queue = new LinkedList<>();
            queue.add(node);

            while (!queue.isEmpty()) {
                Node n = queue.pop();
                for (Node neighbor : n.neighbors) {
                    if (!nodeHashMap.containsKey(neighbor.val)) {
                        nodeHashMap.put(neighbor.val, new Node(neighbor.val));
                        queue.add(neighbor);
                    }
                    nodeHashMap.get(n.val).neighbors.add(nodeHashMap.get(neighbor.val));
                }
            }

            for (Map.Entry<Integer, Node> entry : nodeHashMap.entrySet()) {
                System.out.println("Key: " + entry.getKey() + "[" + entry.getValue().neighbors.toString() + "]");
            }
        }
    }

    private static class Node {
        private int val;
        private List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int val) {
            this.val = val;
            neighbors = new ArrayList<>();
        }

        public Node(int val, List<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }
}
