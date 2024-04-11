package second.leetcode.no155;

import java.util.Stack;

/**
 * @author shijie.qian
 * @date 2024/4/12 02:34
 */
public class MinStack {
    private Stack<Integer> masterStack = null;
    private Stack<Integer> assistStack = null;

    public MinStack() {
        masterStack = new Stack<>();
        assistStack = new Stack<>();
    }

    /**
     * 同步 push, 同步 pop
     */
    public void push(int val) {
        masterStack.push(val);
        if (assistStack.isEmpty()) {
            assistStack.push(val);
        } else {
            assistStack.push(Math.min(val, assistStack.peek()));
        }
    }

    public void pop() {
        masterStack.pop();
        assistStack.pop();
    }

    public int top() {
        return masterStack.peek();
    }

    public int getMin() {
        return assistStack.peek();
    }
}
