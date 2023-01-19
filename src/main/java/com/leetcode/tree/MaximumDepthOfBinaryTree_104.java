package com.leetcode.tree;

//        Given the root of a binary tree, return its maximum depth.
//
//        A binary tree's maximum depth is the number of nodes along the longest path from the root node
//        down to the farthest leaf node.
//
//        Example 1:
//        Input: root = [3,9,20,null,null,15,7]
//        Output: 3
//
//        Example 2:
//        Input: root = [1,null,2]
//        Output: 2

import java.util.*;

public class MaximumDepthOfBinaryTree_104 {

    public static void main(String[] args) {

        TreeNode left = new TreeNode(15, null, null);
        TreeNode right = new TreeNode(7, null, null);

        TreeNode leftNode = new TreeNode(9, null, null);
        TreeNode rightNode = new TreeNode(20, left, right);

        TreeNode treeNode = new TreeNode(3, leftNode, rightNode);

        int maxDepthBFS = maxDepthBFS(treeNode);
        System.out.println("Result: " + maxDepthBFS);

        int resultDFS = maxDepthDFS(treeNode);
        System.out.println("Result: " + resultDFS);
    }

    /**
     * DFS(Depth-first search)
     *
     * Time complexity : O(n)
     * Space complexity : O(1)
     *
     * @param root
     * @return
     */
    public static int maxDepthDFS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        Deque<Integer> value = new ArrayDeque<>();
        stack.push(root);
        value.push(1);

        int max = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int temp = value.pop();

            max = Math.max(temp, max);

            if (node.right != null) {
                stack.push(node.right);
                value.push(temp + 1);
            }

            if (node.left != null) {
                stack.push(node.left);
                value.push(temp + 1);
            }
        }
        return max;
    }

    /**
     * BFS(Breadth-first search)
     *
     * Time complexity : O(n)
     * Space complexity : O(1)
     *
     * @param root
     * @return
     */
    public static int maxDepthBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {

                TreeNode node = queue.poll();
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
            }
            count++;
        }
        return count;
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
