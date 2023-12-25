package second.leetcode.no92;

import second.leetcode.common.ListNode;

/**
 * @author shijie.qian
 * @date 2023/12/26 00:52
 */
public class Solution {
    private ListNode flagNode = null;

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseOne2N(head, right);
        }
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    private ListNode reverseOne2N(ListNode head, int n) {
        if (n == 1) {
            flagNode = head.next;
            return head;
        }
        ListNode previous = head.next;
        ListNode last = reverseOne2N(head.next, n - 1);
        previous.next = head;
        head.next = flagNode;
        return last;
    }
}
