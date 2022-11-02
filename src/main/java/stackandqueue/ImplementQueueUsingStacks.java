package stackandqueue;

import java.util.Stack;

/**
 * @Classname : ImplementQueueUsingStacks
 * @Description : 232. 用栈实现队列
 * https://leetcode.cn/problems/implement-queue-using-stacks/
 * @Author : chentianyu
 * @Date 2022/11/2 22:26
 */


public class ImplementQueueUsingStacks {
    Stack<Integer> a;
    Stack<Integer> b;

    public ImplementQueueUsingStacks() {
        a = new Stack<>();
        b = new Stack<>();
    }

    public void push(int x) {
        a.push(x);
    }

    public int pop() {
        if (b.isEmpty()) {
            while (!a.isEmpty()) {
                b.push(a.pop());
            }
        }
        return b.pop();
    }

    public int peek() {
        if (b.isEmpty()) {
            while (!a.isEmpty()) {
                b.push(a.pop());
            }
        }
        return b.peek();
    }

    public boolean empty() {
        return a.isEmpty() && b.isEmpty();
    }
}
