package com.leetcode.tree;

//        Given the roots of two binary trees root and subRoot, return true if there is a subtree of root
//        with the same structure and node values of subRoot and false otherwise.
//
//        A subtree of a binary tree is a tree that consists of a node in tree and all of
//        this node's descendants. The tree could also be considered as a subtree of itself.
//
//        Example 1:
//        Input: root = [3,4,5,1,2], subRoot = [4,1,2]
//        Output: true
//
//        Example 2:
//        Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
//        Output: false

import com.leetcode.tree.SameTree_100.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SubtreeOfAnotherTree_572 {

    public static void main(String[] args) {
        TreeNode left = new TreeNode(1, null, null);
        TreeNode right = new TreeNode(2, null, null);

        TreeNode leftNode = new TreeNode(4, left, right);
        TreeNode rightNode = new TreeNode(5, null, null);

        TreeNode treeNode = new TreeNode(3, leftNode, rightNode);

        boolean result = isSubtreeRecursive(treeNode, leftNode);
        System.out.println("Result: " + result);
    }

    /**
     * Time complexity : O(mn)
     * Space complexity : O(m+n)
     *
     * @param root
     * @param subRoot
     * @return
     */
    public static boolean isSubtreeRecursive(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }

        if (isIdentical(root, subRoot)) {
            return true;
        }

        return isSubtreeRecursive(root.left, subRoot) || isSubtreeRecursive(root.right, subRoot);
    }

    private static boolean isIdentical(TreeNode node1, TreeNode node2) {

        if (node1 == null || node2 == null) {
            return node1 == null && node2 == null;
        }

        return node1.val == node2.val
                && isIdentical(node1.left, node2.left)
                && isIdentical(node1.right, node2.right);
    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);

        Queue<TreeNode> start = new LinkedList<>();

        while (!nodes.isEmpty()) {
            int size = nodes.size();
            while (size-- > 0) {
                TreeNode node = nodes.poll();
                if (node.val == subRoot.val) {
                    start.add(node);
                }
                if (node.left != null) nodes.offer(node.left);
                if (node.right != null) nodes.offer(node.right);
            }
        }

        while (!start.isEmpty()) {
            if (SameTree_100.isSameTree(start.poll(), subRoot)) {
                return true;
            }
        }
        return false;
    }
}
