package com.wyj.algorithm.test.linked_list;

import com.sun.org.apache.bcel.internal.generic.RET;
import com.sun.org.apache.regexp.internal.RE;

/**
 * @Author Wuyj
 * @DateTime 2022-03-18 14:10
 * @Version 1.0
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists01(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(-1);
        ListNode prev = sentinel;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                prev = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                prev = l2;
                l2 = l2.next;
            }
        }

        prev.next = l1 == null ? l2 : l1;
        return sentinel.next;
    }

    //使用递归实现
    public ListNode mergeTwoLists02(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists02(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists02(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode listNode11 = new ListNode(1);
        ListNode listNode12 = new ListNode(2);
        ListNode listNode13 = new ListNode(4);

        ListNode listNode21 = new ListNode(1);
        ListNode listNode22 = new ListNode(3);
        ListNode listNode23 = new ListNode(4);

        listNode11.next = listNode12;
        listNode12.next = listNode13;
        listNode13.next = null;

        listNode21.next = listNode22;
        listNode22.next = listNode23;
        listNode23.next = null;

        TestLinkedList.printList(listNode11);
        TestLinkedList.printList(listNode21);

        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        TestLinkedList.printList(mergeTwoSortedLists.mergeTwoLists02(listNode11, listNode21));
    }
}
