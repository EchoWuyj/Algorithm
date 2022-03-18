package com.wyj.algorithm.test.linked_list;

import com.sun.xml.internal.ws.encoding.soap.streaming.SOAPNamespaceConstants;
import jdk.nashorn.internal.ir.LiteralNode;

import javax.crypto.SealedObject;
import java.util.List;
import java.util.Stack;

/**
 * @Author Wuyj
 * @DateTime 2022-03-18 18:33
 * @Version 1.0
 */
public class RemoveNthNodeFromEnd {
    //两次遍历的方法
    public ListNode removeNthFromEnd01(ListNode head, int n) {
        int l = getLength(head);

        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;
        ListNode cur = sentinel;

        for (int i = 0; i < l - n; i++) {

            cur = cur.next;
        }
        cur.next = cur.next.next;

        return sentinel.next;
    }

    private int getLength(ListNode head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }

    //使用数据结构栈来实现
    public ListNode removeNthFromEnd02(ListNode head, int n) {
        ListNode sentinel = new ListNode(-1, head);
        ListNode cur = sentinel;

        Stack<ListNode> stack = new Stack<>();
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        stack.peek().next = stack.peek().next.next;
        return sentinel.next;
    }

    //通过双指针实现
    public ListNode removeNthFromEnd03(ListNode head, int n) {
        ListNode sentinel = new ListNode(-1, head);
        ListNode first = sentinel, second = sentinel;

        for (int i = 0; i < n + 1; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return sentinel.next;
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
        RemoveNthNodeFromEnd removeNthNodeFromEnd = new RemoveNthNodeFromEnd();
        TestLinkedList.printList(removeNthNodeFromEnd.removeNthFromEnd03(listNode1, 2));
    }
}
