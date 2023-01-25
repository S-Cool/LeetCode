package com.leetcode.tree;

//        A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in
//        the sequence has an edge connecting them. A node can only appear in the sequence at most once.
//        Note that the path does not need to pass through the root.
//
//        The path sum of a path is the sum of the node's values in the path.
//
//        Given the root of a binary tree, return the maximum path sum of any non-empty path.
//
//        Example 1:
//        Input: root = [1,2,3]
//        Output: 6
//        Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
//
//        Example 2:
//        Input: root = [-10,9,20,null,null,15,7]
//        Output: 42
//        Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class BinaryTreeMaximumPathSum_124 {

    private static int maxSum;

    public static void main(String[] args) {
        TreeNode left1 = new TreeNode(2, null, null);
        TreeNode right1 = new TreeNode(-1, null, null);

        TreeNode left = new TreeNode(1, null, null);
        TreeNode right = new TreeNode(2, null, null);

        TreeNode leftNode = new TreeNode(-3, left1, right1);
        TreeNode rightNode = new TreeNode(5, left, right);

        TreeNode treeNode = new TreeNode(-2, leftNode, rightNode);

        int result = maxPathSum(treeNode);
        System.out.println("Result: " + result);

        int sumRecursive = maxPathSumRecursive(treeNode);
        System.out.println("Recursive Result: " + sumRecursive);
    }

    public static int maxPathSum(TreeNode root) {
        int result = Integer.MIN_VALUE;
        if (root == null) {
            return result;
        }

        Map<TreeNode, Integer> maxRootPath = new HashMap<>();
        maxRootPath.put(null, 0);

        Iterable<TreeNode> treeNodes = postorderSort(root);
        for (TreeNode node : treeNodes) {

            int left = Math.max(maxRootPath.get(node.left), 0);
            int right = Math.max(maxRootPath.get(node.right), 0);
            maxRootPath.put(node, Math.max(left, right) + node.val);
            result = Math.max(left + right + node.val, result);
        }
        return result;
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(n)
     *
     * @param root
     * @return
     */
    public static int maxPathSumRecursive(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        gainFromSubtree(root);
        return maxSum;
    }

    private static int gainFromSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int gainFromLeft = Math.max(gainFromSubtree(root.left), 0);

        int gainFromRight = Math.max(gainFromSubtree(root.right), 0);

        maxSum = Math.max(maxSum, gainFromLeft + gainFromRight + root.val);

        return Math.max(gainFromLeft + root.val, gainFromRight + root.val);
    }

    private static Iterable<TreeNode> postorderSort(TreeNode root) {
        Deque<TreeNode> sorted = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            sorted.push(curr);
            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null) stack.push(curr.left);
        }
        return sorted;
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
