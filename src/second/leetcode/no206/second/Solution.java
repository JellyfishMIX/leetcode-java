package second.leetcode.no206.second;

import second.leetcode.common.ListNode;

/**
 * @author shijie.qian
 * @date 2024/4/24 11:53
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = recursion(head);
        return newHead;
    }

    private ListNode recursion(ListNode node) {
        if (node.next == null) {
            return node;
        }

        ListNode nextNode = node.next;
        ListNode last = recursion(node.next);
        nextNode.next = node;
        node.next = null;
        return last;
    }
}
