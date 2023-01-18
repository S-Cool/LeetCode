package com.leetcode.tree;

import java.util.Stack;

//        Given the roots of two binary trees p and q, write a function to check if they are the same or not.
//
//        Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
//
//        Example 1:
//        Input: p = [1,2,3], q = [1,2,3]
//        Output: true
//
//        Example 2:
//        Input: p = [1,2], q = [1,null,2]
//        Output: false
//
//        Example 3:
//        Input: p = [1,2,1], q = [1,1,2]
//        Output: false

public class SameTree_100 {

    public static void main(String[] args) {
        TreeNode leftNode = new TreeNode(2, null, null);
        TreeNode rightNode = new TreeNode(3, null, null);

        TreeNode treeNode = new TreeNode(1, leftNode, rightNode);

        TreeNode leftNode2 = new TreeNode(2, null, null);
        TreeNode rightNode2 = new TreeNode(3, null, null);

        TreeNode treeNode2 = new TreeNode(1, leftNode2, rightNode2);

        boolean result = isSameTree(treeNode, treeNode2);
        System.out.println("Result: " + result);
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(n)
     *
     * @param p
     * @param q
     * @return
     */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (!checkNode(p, q)) {
            return false;
        }

        Stack<TreeNode> stackP = new Stack();
        Stack<TreeNode> stackQ = new Stack();

        stackP.push(p);
        stackQ.push(q);

        while (!stackP.isEmpty()) {
            TreeNode node1 = stackP.pop();
            TreeNode node2 = stackQ.pop();

            if (!checkNode(node1, node2)) {
                return false;
            }

            if (node1.left != null) {
                stackP.push(node1.left);
                stackQ.push(node2.left);
            }
            if (node1.right != null) {
                stackP.push(node1.right);
                stackQ.push(node2.right);
            }
        }

        return true;
    }

    private static boolean checkNode(TreeNode node1, TreeNode node2) {

        if (node1.val != node2.val) {
            return false;
        }
        if (node1.left == null && node2.left != null) {
            return false;
        }
        if (node1.left != null && node2.left == null) {
            return false;
        }
        if (node1.right == null && node2.right != null) {
            return false;
        }
        if (node1.right != null && node2.right == null) {
            return false;
        }
        return true;
    }

    public static class TreeNode {
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
