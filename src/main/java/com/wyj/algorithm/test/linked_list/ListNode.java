package com.wyj.algorithm.test.linked_list;

/**
 * @Author Wuyj
 * @DateTime 2022-03-18 13:06
 * @Version 1.0
 */
public class ListNode {
    //当前节点的数据
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
