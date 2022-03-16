package com.wyj.algorithm.example.linked_list;

/**
 * @Author Wuyj
 * @DateTime 2022-03-16 10:04
 * @Version 1.0
 */
public class ReverseLinkedList {
    //方法一:迭代
    //基本思路:
    // 我们发现反转链表的过程,其实跟val没有关系,只要把每个节点的next指向之前的节点就可以了
    // 但是在遍历的过程中,只知道当前节点的下一个节点,需要使用额外的指针保存当前节点的前一个节点

    //返回值为反转之后的头节点
    public ListNode reverseList01(ListNode head) {
        //定义两个指针,指向当前访问的节点,以及上一个节点
        ListNode curr = head;
        //头节点反转之后需要指向null
        ListNode prev = null;

        //TODO 暂存 指向 先后归位
        //依次迭代链表中的节点,将next指针指向prev
        while (curr != null) {
            //暂存:临时保存当前节点的下一个节点
            //因为curr.next指针需要反转,若不先保存,则后面的节点就丢失了
            ListNode tempNext = curr.next;

            //指向:curr.next为当前节点的指针,将其指向前一个节点,从而实现反转链表
            curr.next = prev;

            //先后归位:更新指针
            prev = curr;
            curr = tempNext;
        }

        //cur==null
        //prev指向的就是末尾的节点,也就是翻转之后的头节点
        return prev;
    }

    //方法二:递归
    public ListNode reverseList02(ListNode head) {
        return null;
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
        TestLinkedList.printList(reverseLinkedList.reverseList01(listNode1));
    }
}
