package leecode.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: https://leetcode-cn.com/problems/implement-stack-using-queues/
 * 用队列实现栈
 * @author: xwy
 * @create: 20:42 2020/10/18
 **/

public class Solution255 {

    // 使用 2 个队列
//    Queue<Integer> queue1;
//    Queue<Integer> queue2;
//    /** Initialize your data structure here. */
//    public Solution255() {
//        queue1 = new LinkedList<>();
//        queue2 = new LinkedList<>();
//    }
//
//    /** Push element x onto stack. */
//    public void push(int x) {
//        queue1.add(x);
//        while (!queue2.isEmpty()){
//            queue1.add(queue2.poll());
//        }
//        Queue<Integer> temp = queue1;
//        queue1 = queue2;
//        queue2 = temp;
//    }
//
//    /** Removes the element on top of the stack and returns that element. */
//    public int pop() {
//        return queue2.poll();
//    }
//
//    /** Get the top element. */
//    public int top() {
//        return queue2.peek();
//    }
//
//    /** Returns whether the stack is empty. */
//    public boolean empty() {
//        return queue2.isEmpty();
//    }


    // 使用一个队列
    Queue<Integer> queue;
    /** Initialize your data structure here. */
    public Solution255() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        for (int i = 0; i < queue.size()-1; i++) {
            queue.add(queue.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }


    public static void main(String[] args) {
        Solution255 solution255 =  new Solution255();
        solution255.push(1);
        solution255.push(2);
        System.out.println(solution255.top());
        System.out.println(solution255.pop());
    }
}