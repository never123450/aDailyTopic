package leecode.noClassify;

import java.util.Stack;

/**
 * @description: https://leetcode-cn.com/problems/min-stack/
 * 最小栈
 * @author: xwy
 * @create: 20:10 2020/10/13
 **/

public class Solution155 {

    // 利用 2 个栈
//    private Stack<Integer> minStack;
//    private Stack<Integer> stack;
//
//    /**
//     * initialize your data structure here.
//     */
//    public Solution155() {
//        stack = new Stack<>();
//        minStack = new Stack<>();
//    }
//
//    public void push(int x) {
//        stack.push(x);
//        if (minStack.isEmpty()) {
//            minStack.push(x);
//        } else {
//            minStack.push(Math.min(x, minStack.peek()));
//        }
//    }
//
//    public void pop() {
//        stack.pop();
//        minStack.pop();
//    }
//
//    public int top() {
//        return stack.peek();
//    }
//
//    public int getMin() {
//        return minStack.peek();
//    }


    // 使用链表
    private Node head;

    /**
     * initialize your data structure here.
     */
    public Solution155() {
        head = new Node(0, Integer.MAX_VALUE, null);
    }

    public void push(int x) {
        head = new Node(x, Math.min(x, head.min), head);
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    private static class Node {
        public int val;
        public int min;
        public Node next;

        public Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}