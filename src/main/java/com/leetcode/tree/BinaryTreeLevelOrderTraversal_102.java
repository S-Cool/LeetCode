package com.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//        Given the root of a binary tree, return the level order traversal of its
//        nodes values. (i.e., from left to right, level by level).
//
//        Example 1:
//        Input: root = [3,9,20,null,null,15,7]
//        Output: [[3],[9,20],[15,7]]
//
//        Example 2:
//        Input: root = [1]
//        Output: [[1]]
//
//        Example 3:
//        Input: root = []
//        Output: []

public class BinaryTreeLevelOrderTraversal_102 {

    public static void main(String[] args) {
        TreeNode left = new TreeNode(15, null, null);
        TreeNode right = new TreeNode(7, null, null);

        TreeNode leftNode = new TreeNode(9, null, null);
        TreeNode rightNode = new TreeNode(20, left, right);

        TreeNode treeNode = new TreeNode(3, leftNode, rightNode);

        List<List<Integer>> lists = levelOrder(treeNode);
        System.out.println("Result: " + lists);
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(n)
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(list);
        }
        return result;
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
