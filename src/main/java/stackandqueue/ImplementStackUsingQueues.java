package stackandqueue;

import java.util.*;

/**
 * @Classname : ImplementStackUsingQueues
 * @Description : 225. 用队列实现栈
 * https://leetcode.cn/problems/implement-stack-using-queues/
 * @Author : chentianyu
 * @Date 2022/11/2 23:04
 */


public class ImplementStackUsingQueues {
    private Queue<Integer> a;
    private Queue<Integer> b;

    public ImplementStackUsingQueues() {
        a = new LinkedList<>();
        b = new LinkedList<>();
    }

    public void push(int x) {
        // b为辅助队列
        b.offer(x);
        while (!a.isEmpty()) {
            b.offer(a.poll());
        }
        Queue<Integer> c = a;
        a = b;
        b = c;
    }

    public int pop() {
        return a.poll();
    }

    public int top() {
        return a.peek();
    }

    public boolean empty() {
        return a.isEmpty();
    }
}
