package second.leetcode.no206;

import second.leetcode.common.ListNode;

/**
 * @author shijie.qian
 * @date 2023/12/22 01:21
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        return recursion(head);
    }

    private ListNode recursion(ListNode previous) {
        // 递归结束条件
        if (previous.next == null) {
            return previous;
        }
        // 下一个节点
        ListNode latter = previous.next;
        // 递归中透传的最后一个 last 节点
        ListNode last = recursion(latter);
        // 后节点指向前节点
        latter.next = previous;
        // 前节点向后指针断开
        previous.next = null;
        // 透传最后一个 last 节点
        return last;
    }
}
