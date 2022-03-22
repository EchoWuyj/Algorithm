package com.wyj.algorithm.test.stack_and_queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Wuyj
 * @DateTime 2022-03-22 17:05
 * @Version 1.0
 */
public class MyStack2 {
    //通过一个队列实现
    Queue<Integer> queue;

    public MyStack2() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        int size = queue.size();

        queue.offer(x);
        for (int i = 0; i < size; i++) {
            queue.offer(queue.poll());
        }
    }

    public int top() {
        return queue.peek();
    }

    public int pop() {
        return queue.poll();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
