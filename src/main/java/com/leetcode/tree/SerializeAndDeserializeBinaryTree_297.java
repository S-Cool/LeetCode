package com.leetcode.tree;

//        Serialization is the process of converting a data structure or object into a sequence of bits
//        so that it can be stored in a file or memory buffer, or transmitted across a network connection
//        link to be reconstructed later in the same or another computer environment.
//
//        Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how
//        your serialization/deserialization algorithm should work. You just need to ensure that a binary
//        tree can be serialized to a string and this string can be deserialized to the original tree structure.
//
//        Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do
//        not necessarily need to follow this format, so please be creative and come up with different
//        approaches yourself.
//
//        Example 1:
//        Input: root = [1,2,3,null,null,4,5]
//        Output: [1,2,3,null,null,4,5]
//
//        Example 2:
//        Input: root = []
//        Output: []

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree_297 {

    public static void main(String[] args) {
        TreeNode left1 = new TreeNode(4, null, null);
        TreeNode right1 = new TreeNode(5, null, null);

        TreeNode left = new TreeNode(6, null, null);
        TreeNode right = new TreeNode(7, null, null);

        TreeNode leftNode = new TreeNode(2, left1, right1);
        TreeNode rightNode = new TreeNode(3, left, right);

        TreeNode treeNode = new TreeNode(1, leftNode, rightNode);

        String serialize = serialize(treeNode);
        System.out.println("Result: " + serialize);

        TreeNode deserialize = deserialize(serialize);
        System.out.println("Result: " + deserialize);
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(n)
     *
     * @param root
     * @return
     */
    public static String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                res.append("# ");
                continue;
            }

            res.append(node.val).append(" ");
            queue.add(node.left);
            queue.add(node.right);
        }
        return res.toString();
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(n)
     *
     * @param data
     * @return
     */
    public static TreeNode deserialize(String data) {
        if (Objects.equals(data, "")) {
            return null;
        }

        String[] values = data.split(" ");

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        nodeQueue.add(root);

        for (int i = 1; i < values.length; i++) {
            TreeNode parent = nodeQueue.poll();
            if (!values[i].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                nodeQueue.add(left);
            }
            if (!values[++i].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                nodeQueue.add(right);
            }
        }
        return root;
    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }
}
