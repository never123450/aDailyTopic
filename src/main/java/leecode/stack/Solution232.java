package leecode.stack;


import java.util.Stack;

/**
 * @description: https://leetcode-cn.com/problems/implement-queue-using-stacks/
 * 使用栈实现队列
 * <p>
 * inStack
 * outStack
 * @author: xwy
 * @create: 8:05 PM 2020/7/15
 **/

public class Solution232 {

    /**
     * Initialize your data structure here.
     */
    public Solution232() {

    }

    private Stack<Integer> inStack = new Stack<>();
    private Stack<Integer> outStack = new Stack<>();

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        inStack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {

        checkOutStack();
        return outStack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        checkOutStack();
        return outStack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void checkOutStack() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }


}