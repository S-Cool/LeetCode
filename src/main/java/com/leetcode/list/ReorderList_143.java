package com.leetcode.list;

//        You are given the head of a singly linked-list. The list can be represented as:
//
//        L0 → L1 → … → Ln - 1 → Ln
//        Reorder the list to be on the following form:
//
//        L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
//        You may not modify the values in the list's nodes. Only nodes themselves may be changed.
//
//        Example 1:
//        Input: head = [1,2,3,4]
//        Output: [1,4,2,3]
//
//        Example 2:
//        Input: head = [1,2,3,4,5]
//        Output: [1,5,2,4,3]

public class ReorderList_143 {

    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5, null);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);
        reorderList(listNode1);

        while (listNode1.next != null) {
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }
        System.out.println(listNode1.val);
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * @param head
     */
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode left = slow;
        ListNode right = slow.next;
        while (right.next != null) {
            ListNode current = right.next;
            right.next = current.next;
            current.next = left.next;
            left.next = current;
        }

        slow = head;
        fast = left.next;
        while (slow != left) {
            left.next = fast.next;
            fast.next = slow.next;
            slow.next = fast;
            slow = fast.next;
            fast = left.next;
        }
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
