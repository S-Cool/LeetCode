package com.leetcode.tree.additionally;

//Given the root of a binary tree, return the sum of all left leaves.
//
//A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.
//
//        Example 1:
//        Input: root = [3,9,20,null,null,15,7]
//        Output: 24
//        Explanation: There are two left leaves in the binary tree, with values 9 and 15 respectively.
//
//                  3
//                /   \
//              9      20
//            / \      /  \
//         null null  15   7
//
//        Example 2:
//        Input: root = [1]
//        Output: 0

public class SumOfLeftLeaves_404 {

    public static void main(String[] args) {

        TreeNode left = new TreeNode(15);
        TreeNode right = new TreeNode(7);

        TreeNode leftNode = new TreeNode(9);
        TreeNode rightNode = new TreeNode(20, left, right);

        TreeNode treeNode = new TreeNode(3, leftNode, rightNode);

        int sumOfLeftLeaves = sumOfLeftLeaves(treeNode);
        System.out.println("Result: " + sumOfLeftLeaves);
    }

    private static int  sum = 0;

    /**
     * Time complexity : O(n)
     * Space complexity : O(h) where h is the height of the tree
     *
     * @param root - root of tree
     * @return sum of left leaves
     */
    public static int sumOfLeftLeaves(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 0;
        }

        sumOfLeftLeaves(root, false);
        return sum;
    }

    static void sumOfLeftLeaves(TreeNode root, boolean isLeftNode) {
        if (isLeftNode && root.left == null && root.right == null) {
            sum += root.val;
        }
        if (root.left != null) {
            sumOfLeftLeaves(root.left, true);
        }
        if (root.right != null) {
            sumOfLeftLeaves(root.right, false);
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

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
