package com.wyj.algorithm.example.linked_list;

/**
 * @Author Wuyj
 * @DateTime 2022-03-16 10:28
 * @Version 1.0
 */
public class ListNode {
    //当前节点保存的数据值
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
