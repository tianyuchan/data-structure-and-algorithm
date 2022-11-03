package stackandqueue;

import java.util.Stack;

/**
 * @Classname : MinStack
 * @Description : 155. 最小栈
 * https://leetcode.cn/problems/min-stack/
 * @Author : chentianyu
 * @Date 2022/11/3 22:31
 */


public class MinStack {
    private Stack<Integer> stack, minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        // 维护最小栈
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        int val = stack.pop();
        if (!minStack.isEmpty() && val == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
