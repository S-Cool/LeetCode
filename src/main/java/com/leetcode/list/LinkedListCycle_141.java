package com.leetcode.list;

//        Given head, the head of a linked list, determine if the linked list has a cycle in it.
//
//        There is a cycle in a linked list if there is some node in the list that can be reached again
//        by continuously following the next pointer. Internally, pos is used to denote the index of
//        the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
//
//        Return true if there is a cycle in the linked list. Otherwise, return false.
//
//        Example 1:
//        Input: head = [3,2,0,-4], pos = 1
//        Output: true
//        Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
//
//        Example 2:
//        Input: head = [1,2], pos = 0
//        Output: true
//        Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
//
//        Example 3:
//        Input: head = [1], pos = -1
//        Output: false
//        Explanation: There is no cycle in the linked list.

public class LinkedListCycle_141 {

    public static void main(String[] args) {

        ListNode listNode5 = new ListNode(5, null);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);
        listNode5.next = listNode1;
        boolean hasCycle = hasCycle(listNode1);
        System.out.println("Result: " + hasCycle);
    }

    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }

        return false;
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
