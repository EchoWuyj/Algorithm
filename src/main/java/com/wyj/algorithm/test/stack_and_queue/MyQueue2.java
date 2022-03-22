package com.wyj.algorithm.test.stack_and_queue;

import java.util.Stack;

/**
 * @Author Wuyj
 * @DateTime 2022-03-22 18:22
 * @Version 1.0
 */
public class MyQueue2 {
    //出队时反转
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue2() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
