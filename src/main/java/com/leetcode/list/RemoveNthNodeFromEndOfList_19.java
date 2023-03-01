package com.leetcode.list;

//        Given the head of a linked list, remove the nth node from the end of the list and return its head.
//
//        Example 1:
//        Input: head = [1,2,3,4,5], n = 2
//        Output: [1,2,3,5]
//
//        Example 2:
//        Input: head = [1], n = 1
//        Output: []
//
//        Example 3:
//        Input: head = [1,2], n = 1
//        Output: [1]

public class RemoveNthNodeFromEndOfList_19 {

    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5, null);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);
        ListNode listNode = removeNthFromEnd(listNode1, 1);

        while (listNode.next != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
        System.out.println(listNode.val);
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0, head);
        ListNode left = dummy;
        ListNode right = dummy;

        for (int i = 1; i <= n + 1; i++) {
            right = right.next;
        }

        while (right != null) {
            left = left.next;
            right = right.next;
        }

        left.next = left.next.next;

        return dummy.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
