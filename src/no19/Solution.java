package no19;

/**
 * 19. 删除链表的倒数第 N 个结点
 * link: https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 *
 * @author JellyfishMIX
 * @date 2021/8/19 20:46
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode front = dummy;
        ListNode back = head;
        // back 节点向后移动 n 次
        for (int i = 0; i < n; i++) {
            back = back.next;
        }
        // 前后指针一起移动
        while (back != null) {
            back = back.next;
            front = front.next;
        }
        // 此时 front.next 即为需要删除的节点
        removeNext(front);
        return dummy.next;
    }

    private void removeNext(ListNode specificNode) {
        specificNode.next = specificNode.next.next;
    }
}
