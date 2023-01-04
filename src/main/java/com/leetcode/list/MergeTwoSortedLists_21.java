package com.leetcode.list;

//        You are given the heads of two sorted linked lists list1 and list2.
//
//        Merge the two lists in a one sorted list. The list should be made by splicing together
//        the nodes of the first two lists.
//
//        Return the head of the merged linked list.
//
//        Example 1:
//        Input: list1 = [1,2,4], list2 = [1,3,4]
//        Output: [1,1,2,3,4,4]
//
//        Example 2:
//        Input: list1 = [], list2 = []
//        Output: []
//
//        Example 3:
//        Input: list1 = [], list2 = [0]
//        Output: [0]

public class MergeTwoSortedLists_21 {

    public static void main(String[] args) {

        ListNode list6 = new ListNode(4, null);
        ListNode list5 = new ListNode(3, list6);
        ListNode list4 = new ListNode(1, list5);

        ListNode list3 = new ListNode(4, null);
        ListNode list2 = new ListNode(2, list3);
        ListNode list1 = new ListNode(1, list2);

        ListNode listNode = mergeTwoLists(list1, list4);
        System.out.println("Result: " + listNode);
    }

    /**
     * Time complexity: O(n * logn)
     * Space complexity: O(n)
     *
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(0);
        ListNode last = result;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                last.next = list2;
                list2 = list2.next;
            } else {
                last.next = list1;
                list1 = list1.next;
            }
            last = last.next;
        }

        if (list1 == null) {
            last.next = list2;
        } else {
            last.next = list1;
        }

        return result.next;
    }

    public static class ListNode {
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

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
