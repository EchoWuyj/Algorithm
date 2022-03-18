package com.wyj.algorithm.test.linked_list;

/**
 * @Author Wuyj
 * @DateTime 2022-03-18 13:21
 * @Version 1.0
 */
public class ReverseLinkedList {
    public ListNode reverseList01(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            ListNode tempNext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tempNext;
        }
        return prev;
    }

    public ListNode reverseList02(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode reverseRest = reverseList02( head.next);

        head.next.next = head;
        head.next = null;
        return reverseRest;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = null;
        TestLinkedList.printList(listNode1);

        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        TestLinkedList.printList(reverseLinkedList.reverseList02(listNode1));
    }
}
