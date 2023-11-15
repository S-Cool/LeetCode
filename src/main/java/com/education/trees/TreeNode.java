package com.education.trees;

import java.util.ArrayDeque;
import java.util.Deque;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public static void recursivePreorder(TreeNode rootNode) {
        if (rootNode != null) {
            // Process the root node
            System.out.print(rootNode.val + ", ");
            recursivePreorder(rootNode.left);
            recursivePreorder(rootNode.right);
        }
    }

    public static void recursiveInorder(TreeNode rootNode) {
        if (rootNode != null) {
            recursiveInorder(rootNode.left);
            // Process the root node
            System.out.print(rootNode.val + ", ");
            recursiveInorder(rootNode.right);
        }
    }

    public static void recursivePostorder(TreeNode rootNode) {
        if (rootNode != null) {
            recursivePostorder(rootNode.left);
            recursivePostorder(rootNode.right);
            // Process the root node
            System.out.print(rootNode.val + ", ");
        }
    }

    public static void iterativePreorder(TreeNode rootNode) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(rootNode);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            System.out.print(current.val + ", ");

            if (current.right != null) {
                stack.push(current.right);
            }

            if (current.left != null) {
                stack.push(current.left);
            }
        }
    }

    public static void iterativeInorder(TreeNode rootNode) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode current = rootNode;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            System.out.print(current.val + ", ");
            current = current.right;
        }
    }

    public static void iterativePostorder(TreeNode rootNode) {
        Deque<TreeNode> stackFirst = new ArrayDeque<>();
        Deque<TreeNode> stackSecond = new ArrayDeque<>();

        stackFirst.push(rootNode);

        while (!stackFirst.isEmpty()) {
            TreeNode current = stackFirst.pop();
            stackSecond.push(current);

            if (current.left != null) {
                TreeNode left1 = current.left;
                stackFirst.push(left1);
            }

            if (current.right != null) {
                TreeNode right1 = current.right;
                stackFirst.push(right1);
            }
        }

        while (!stackSecond.isEmpty()) {
            System.out.print(stackSecond.pop().val + ", ");
        }
    }

    /**
     * Preorder Traversal:
     * [1, 2, 4, 5, 3, 6, 7]
     *
     * Inorder Traversal:
     * [4, 2, 5, 1, 6, 3, 7]
     *
     * Postorder Traversal:
     * [4, 5, 2, 6, 7, 3, 1]
     *
     * @param args
     */
    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("Preorder Traversal:");
        recursivePreorder(root);
        System.out.println("");
        iterativePreorder(root);
        System.out.println("");
        System.out.println("Inorder Traversal:");
        recursiveInorder(root);
        System.out.println("");
        iterativeInorder(root);
        System.out.println("");
        System.out.println("Postorder Traversal:");
        recursivePostorder(root);
        System.out.println("");
        iterativePostorder(root);
    }
}


