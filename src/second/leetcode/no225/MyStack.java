package second.leetcode.no225;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 思路是 push 时保证每个新加入的元素都在 assistQueue 队首, 然后把 masterQueue 拼接到 assistQueue 后面
 *
 * @author shijie.qian
 * @date 2024/1/15 11:48
 */
class MyStack {
    private Queue<Integer> masterQueue;
    private Queue<Integer> assistQueue;

    public MyStack() {
        masterQueue = new LinkedList<>();
        assistQueue = new LinkedList<>();
    }

    public void push(int x) {
        if (masterQueue.isEmpty()) {
            masterQueue.offer(x);
            return;
        }
        assistQueue.offer(x);
        while (!masterQueue.isEmpty()) {
            assistQueue.offer(masterQueue.poll());
        }
        // master 和 assist 交换
        Queue<Integer> tempQueue = masterQueue;
        masterQueue = assistQueue;
        assistQueue = tempQueue;
    }

    public int pop() {
        return masterQueue.poll();
    }

    public int top() {
        return masterQueue.peek();
    }

    public boolean empty() {
        return masterQueue.isEmpty();
    }
}
