package first.no225;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. 用队列实现栈
 * link: https://leetcode-cn.com/problems/implement-stack-using-queues/
 *
 * @author JellyfishMIX
 * @date 2021/8/20 15:06
 */
public class MyStack {
    Queue<Integer> masterQueue;
    Queue<Integer> assistQueue;


    /** Initialize your data structure here. */
    public MyStack() {
        masterQueue = new LinkedList<>();
        assistQueue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if (masterQueue.isEmpty()) {
            masterQueue.offer(x);
            return;
        }
        assistQueue.offer(x);
        while (!masterQueue.isEmpty()) {
            assistQueue.offer(masterQueue.poll());
        }
        Queue<Integer> tempQueue = masterQueue;
        masterQueue = assistQueue;
        assistQueue = tempQueue;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return masterQueue.poll();
    }

    /** Get the top element. */
    public int top() {
        return masterQueue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return masterQueue.isEmpty();
    }
}
