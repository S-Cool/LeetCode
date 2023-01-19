package com.leetcode.tree;

//        Given two integer arrays preorder and inorder where preorder is the preorder traversal of
//        a binary tree and inorder is the inorder traversal of the same tree, construct and
//        return the binary tree.
//
//        Example 1:
//        Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//        Output: [3,9,20,null,null,15,7]
//
//        Example 2:
//        Input: preorder = [-1], inorder = [-1]
//        Output: [-1]

import java.util.*;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal_105 {

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode resultRecursive = buildTreeRecursive(preorder, inorder);
        System.out.println("Result Recursive:");
        print(resultRecursive);

        TreeNode resultIterative = buildTreeIterative(preorder, inorder);
        System.out.println("\nResult Iterative:");
        print(resultIterative);
    }

    private static int preorderIndex;
    private static Map<Integer, Integer> inorderIndexMap;

    public static TreeNode buildTreeRecursive(int[] preorder, int[] inorder) {
        preorderIndex = 0;

        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return arrayToTree(preorder, 0, preorder.length - 1);
    }

    private static TreeNode arrayToTree(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }

        // select the preorder_index element as the root and increment it
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        // build left and right subtree
        // excluding inorderIndexMap[rootValue] element because it's the root
        root.left = arrayToTree(preorder, left, inorderIndexMap.get(rootValue) - 1);
        root.right = arrayToTree(preorder, inorderIndexMap.get(rootValue) + 1, right);
        return root;
    }

    public static TreeNode buildTreeIterative(int[] preorder, int[] inorder) {
        if (inorder.length == 0) {
            return null;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.MIN_VALUE);
        stack.push(root);

        int preIndex = 0;
        int inIndex = 0;

        TreeNode node = null;
        TreeNode current = root;

        while (inIndex < inorder.length) {
            if (stack.peek().val == inorder[inIndex]) {
                node = stack.pop();
                inIndex++;
            } else if (node != null) {
                current = new TreeNode(preorder[preIndex]);
                node.right = current;
                node = null;
                stack.push(current);
                preIndex++;
            } else {
                current = new TreeNode(preorder[preIndex]);
                stack.peek().left = current;
                stack.push(current);
                preIndex++;
            }
        }
        return root.left;
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
