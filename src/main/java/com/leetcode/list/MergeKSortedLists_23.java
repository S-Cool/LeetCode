package com.leetcode.list;

//        You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
//
//        Merge all the linked-lists into one sorted linked-list and return it.
//
//        Example 1:
//        Input: lists = [[1,4,5],[1,3,4],[2,6]]
//        Output: [1,1,2,3,4,4,5,6]
//        Explanation: The linked-lists are:
//        [
//        1->4->5,
//        1->3->4,
//        2->6
//        ]
//        merging them into one sorted list:
//        1->1->2->3->4->4->5->6
//
//        Example 2:
//        Input: lists = []
//        Output: []
//
//        Example 3:
//        Input: lists = [[]]
//        Output: []

import java.util.PriorityQueue;

public class MergeKSortedLists_23 {

    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5, null);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode1 = new ListNode(1, listNode4);

        ListNode listNode44 = new ListNode(4, null);
        ListNode listNode3 = new ListNode(3, listNode44);
        ListNode listNode11 = new ListNode(1, listNode3);

        ListNode listNode6 = new ListNode(6, null);
        ListNode listNode2 = new ListNode(2, listNode6);

        ListNode[] list = new ListNode[3];
        list[0] = listNode1;
        list[1] = listNode11;
        list[2] = listNode2;

        ListNode listNode = mergeKLists(list);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    /**
     * Time complexity: O(n * logn)
     * Space complexity: O(n)
     *
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        ListNode head = null;
        ListNode tail = null;

        PriorityQueue<Integer> queue = new PriorityQueue<>(Integer::compare);
        while (!isEmpty(lists)) {
            for (ListNode node : lists) {
                if (node != null) {
                    queue.offer(node.val);
                }
            }

            if (head == null) {
                head = new ListNode(queue.peek());
                tail = head;
            } else {
                head.next = new ListNode(queue.peek());
                head = head.next;
            }

            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && lists[i].val == queue.peek()) {
                    lists[i] = lists[i].next;
                    break;
                }
            }
            queue.clear();
        }

        return tail;
    }

    private static boolean isEmpty(ListNode[] lists) {
        boolean empty = true;
        for (ListNode node : lists) {
            if (node != null) {
                empty = false;
                break;
            }
        }
        return empty;
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

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
