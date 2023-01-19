package com.leetcode.tree;

//        Given the root of a binary search tree, and an integer k, return the kth smallest
//        value (1-indexed) of all the values of the nodes in the tree.
//
//        Example 1:
//        Input: root = [3,1,4,null,2], k = 1
//        Output: 1
//
//        Example 2:
//        Input: root = [5,3,6,2,4,null,null,1], k = 3
//        Output: 3

import java.util.ArrayDeque;
import java.util.Deque;

public class KthSmallestElementInaBST_230 {

    public static void main(String[] args) {
        TreeNode left = new TreeNode(6, null, null);
        TreeNode right = new TreeNode(10, null, null);

        TreeNode left2 = new TreeNode(1, null, null);
        TreeNode right2 = new TreeNode(4, null, null);

        TreeNode leftNode = new TreeNode(3, left2, right2);
        TreeNode rightNode = new TreeNode(8, left, right);

        TreeNode treeNode = new TreeNode(5, leftNode, rightNode);

        int result = kthSmallest(treeNode, 3);
        System.out.println("Result: " + result);
    }

    /**
     * DFS Inorder Left->Node->Right
     *
     * Time complexity : O(H + k)
     * Space complexity : O(H)
     *
     * H - is a tree height.
     *
     * @param root
     * @param k
     * @return
     */
    public static int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        int counter = 0;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            TreeNode node = stack.pop();
            counter++;

            if (counter == k) {
                return node.val;
            }

            root = node.right;
        }

        return -1;
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
