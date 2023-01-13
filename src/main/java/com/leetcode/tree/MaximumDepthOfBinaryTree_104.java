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

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumDepthOfBinaryTree_104 {

    public static void main(String[] args) {


        TreeNode left = new TreeNode(15, null, null);
        TreeNode right = new TreeNode(7, null, null);

        TreeNode leftNode = new TreeNode(9, null, null);
        TreeNode rightNode = new TreeNode(20, left, right);

        TreeNode treeNode = new TreeNode(3, leftNode, rightNode);

        int result = maxDepth(treeNode);
        System.out.println("Result: " + result);
    }

    /**
     * DFS(Depth-first search)
     *
     * Time complexity : O(n^2)
     * Space complexity : O(1)
     *
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
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

            if (node.left != null) {
                stack.push(node.left);
                value.push(temp + 1);
            }

            if (node.right != null) {
                stack.push(node.right);
                value.push(temp + 1);
            }
        }
        return max;
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
    }
}
