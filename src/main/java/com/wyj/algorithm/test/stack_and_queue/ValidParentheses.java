package com.wyj.algorithm.test.stack_and_queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author Wuyj
 * @DateTime 2022-03-22 18:38
 * @Version 1.0
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        //推荐使用LinkedList的方式来实现栈的功能
        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.pop() != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid("()[]{}"));
        System.out.println(validParentheses.isValid("(]"));
        System.out.println(validParentheses.isValid("([)]"));
        System.out.println(validParentheses.isValid("{[]}"));
        System.out.println(validParentheses.isValid("()"));
    }
}
