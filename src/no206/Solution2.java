package no206;

/**
 * 递归
 *
 * @author JellyfishMIX
 * @date 2021/8/5 13:52
 */
public class Solution2 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
