package com.leetcode.graph;

import java.util.*;

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
