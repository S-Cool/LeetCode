package com.leetcode.tree;

//        Given the root of a binary tree, invert the tree, and return its root.
//
//        Example 1:
//        Input: root = [4,2,7,1,3,6,9]
//        Output: [4,7,2,9,6,3,1]
//
//        Example 2:
//        Input: root = [2,1,3]
//        Output: [2,3,1]
//
//        Example 3:
//        Input: root = []
//        Output: []

import java.util.*;

public class InvertBinaryTree_226 {

    public static void main(String[] args) {
        TreeNode left1 = new TreeNode(1, null, null);
        TreeNode right1 = new TreeNode(3, null, null);

        TreeNode left = new TreeNode(6, null, null);
        TreeNode right = new TreeNode(9, null, null);

        TreeNode leftNode = new TreeNode(2, left1, right1);
        TreeNode rightNode = new TreeNode(7, left, right);

        TreeNode treeNode = new TreeNode(4, leftNode, rightNode);

        System.out.println("BEFORE: ");
        print(treeNode);

        TreeNode result = invertTree(treeNode);
        System.out.println("\n\nAFTER: ");
        print(result);
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(n)
     *
     * @param root
     * @return
     */
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        Deque<TreeNode> node = new ArrayDeque<>();
        node.push(root);

        while (!node.isEmpty()) {
            TreeNode treeNode = node.pop();
            TreeNode temp = treeNode.left;
            treeNode.left = treeNode.right;
            treeNode.right = temp;

            if (treeNode.left != null) node.push(treeNode.left);
            if (treeNode.right != null) node.push(treeNode.right);
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
            return "TreeNode{" + "val=" + val + '}';
        }
    }

    private static void print(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {

                TreeNode node = queue.poll();
                result.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        System.out.println(result);
    }
}
