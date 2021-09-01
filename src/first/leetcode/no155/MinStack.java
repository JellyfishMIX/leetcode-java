package first.leetcode.no155;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 155. 最小栈
 * link: https://leetcode-cn.com/problems/min-stack/
 *
 * @author JellyfishMIX
 * @date 2021/8/28 11:25
 */
public class MinStack {
    private Deque<Integer> masterStack;
    private Deque<Integer> assistStack;

    /** initialize your data structure here. */
    public MinStack() {
        this.masterStack = new LinkedList<>();
        this.assistStack = new LinkedList<>();
    }

    public void push(int val) {
        masterStack.push(val);
        if (!assistStack.isEmpty()) {
            int top = assistStack.peek();
            assistStack.push(Math.min(top, val));
        } else {
            assistStack.push(val);
        }
    }

    public void pop() {
        masterStack.pop();
        assistStack.pop();
    }

    public int top() {
        if (masterStack.isEmpty()) {
            throw new RuntimeException("栈中元素为空，此操作非法");
        }
        return masterStack.peek();
    }

    public int getMin() {
        if (assistStack.isEmpty()) {
            throw new RuntimeException("栈中元素为空，此操作非法");
        }
        return assistStack.peek();
    }
}
