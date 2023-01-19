package com.leetcode.tree;

//        Given the root of a binary tree, determine if it is a valid binary search tree (BST).
//
//        A valid BST is defined as follows:
//
//        The left subtree of a node contains only nodes with keys less than the node's key.
//        The right subtree of a node contains only nodes with keys greater than the node's key.
//        Both the left and right subtrees must also be binary search trees.
//
//        Example 1:
//        Input: root = [2,1,3]
//        Output: true
//
//        Example 2:
//        Input: root = [5,1,4,null,null,3,6]
//        Output: false
//        Explanation: The root node's value is 5 but its right child's value is 4.

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidateBinarySearchTree_98 {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(6, null, null);
        TreeNode right = new TreeNode(10, null, null);

        TreeNode left2 = new TreeNode(1, null, null);
        TreeNode right2 = new TreeNode(4, null, null);

        TreeNode leftNode = new TreeNode(3, left2, right2);
        TreeNode rightNode = new TreeNode(8, left, right);

        TreeNode treeNode = new TreeNode(5, leftNode, rightNode);
        boolean result = isValidBST(treeNode);
        System.out.println("Result: " + result);
    }

    /**
     * Iterative Inorder Traversal
     *
     * Time complexity : O(n)
     * Space complexity : O(n)
     *
     * @param root
     * @return
     */
    public static boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        Integer prev = null;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            if (prev != null && root.val <= prev) {
                return false;
            }

            prev = root.val;
            root = root.right;
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
