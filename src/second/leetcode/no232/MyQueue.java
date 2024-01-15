package second.leetcode.no232;

import java.util.Stack;

/**
 * @author shijie.qian
 * @date 2024/1/15 14:28
 */
class MyQueue {
    private Stack<Integer> masterStack;
    private Stack<Integer> assistStack;

    public MyQueue() {
        masterStack = new Stack<>();
        assistStack = new Stack<>();
    }

    public void push(int x) {
        while (!masterStack.isEmpty()) {
            assistStack.push(masterStack.pop());
        }
        assistStack.push(x);
        while (!assistStack.isEmpty()) {
            masterStack.push(assistStack.pop());
        }
    }

    public int pop() {
        return masterStack.pop();
    }

    public int peek() {
        return masterStack.peek();
    }

    public boolean empty() {
        return masterStack.isEmpty();
    }
}
