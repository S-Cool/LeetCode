package com.leetcode.list;

//        Given the head of a singly linked list, reverse the list, and return the reversed list.
//
//        Example 1:
//        Input: head = [1,2,3,4,5]
//        Output: [5,4,3,2,1]
//
//        Example 2:
//        Input: head = [1,2]
//        Output: [2,1]
//
//        Example 3:
//        Input: head = []
//        Output: []

public class ReverseLinkedList_206 {

    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5, null);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);
        ListNode listNode = reverseList(listNode1);

        while (listNode.next != null){
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
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while(current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
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
