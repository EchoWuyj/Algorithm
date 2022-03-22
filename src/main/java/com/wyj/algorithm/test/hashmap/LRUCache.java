package com.wyj.algorithm.test.hashmap;

import com.sun.xml.internal.bind.marshaller.NoEscapeHandler;

import java.util.HashMap;
import java.util.Timer;

/**
 * @Author Wuyj
 * @DateTime 2022-03-22 13:59
 * @Version 1.0
 */

//自定义实现HashMap+双向链表的缓存机制
public class LRUCache {
    class Node {
        int key;
        int value;
        Node next;
        Node prev;

        public Node() {

        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private int size;

    private Node head;
    private Node tail;

    private HashMap<Integer, Node> hashMap = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;

        head = new Node();
        tail = new Node();

        head.next = tail;
        tail.prev = head;
    }

    //get
    public int get(int key) {
        Node node = hashMap.get(key);
        if (node == null) {
            return -1;
        }

        moveToTail(node);
        return node.value;
    }

    //put
    public void put(int key, int value) {
        Node node = hashMap.get(key);

        //存在
        if (node != null) {
            node.value = value;
            moveToTail(node);
        } else {
            //不存在
            Node newNode = new Node(key, value);
            hashMap.put(key, newNode);
            addToTail(newNode);
            size++;

            if (size > capacity) {
                Node realHead = removeHead();
                hashMap.remove(realHead.key);
                size--;
            }
        }
    }

    private void moveToTail(Node node) {
        //1.删除
        removeNode(node);
        //2.add
        addToTail(node);
    }

    private void addToTail(Node node) {
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private Node removeHead() {
        Node readHead = head.next;
        removeNode(readHead);
        return readHead;
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); //缓存是 {1=1}
        lRUCache.put(2, 2); //缓存是 {1=1, 2=2}
        System.out.println(lRUCache.get(1));   //返回 1
        lRUCache.put(3, 3); //该操作会使得关键字 2 作废,缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(2));    //返回 -1 (未找到)
        lRUCache.put(4, 4); //该操作会使得关键字 1 作废,缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1));     //返回 -1 (未找到)
        System.out.println(lRUCache.get(3));     //返回 3
        System.out.println(lRUCache.get(4));     //返回 4
    }
}
