package com.yandex.practicum.tree;

//Task: Sum of Leaves in Binary Tree
//
//        Given a binary tree, find the sum of all leaf nodes. A leaf node is a node with no children.
//
//        Write a function sumOfLeaves that takes the root of the binary tree as input and returns the sum of
//        all leaf nodes' values.
//
//        Example:
//            1
//           / \
//          2   3
//         / \
//        4   5
//        The sum of leaf nodes is 12 (4 + 5 + 3).

public class TreeLeafSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        TreeLeafSum treeLeafSum = new TreeLeafSum();
        int result = treeLeafSum.sumOfLeaves(root);
        System.out.println(result);
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * @param root - root of tree
     * @return - the sum of all leaf nodes values
     */
    public int sumOfLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        return sumOfLeaves(root.left) + sumOfLeaves(root.right);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

