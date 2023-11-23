package second.leetcode.no83;

import second.leetcode.common.ListNode;

/**
 * @author shijie.qian
 * @date 2023/11/23 23:19
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode last = fast;
        while (fast != null) {
            if (last.val != fast.val) {
                slow.next = fast;
                slow = slow.next;
            }
            last = fast;
            fast = fast.next;
        }
        slow.next = null;
        return head;
    }
}
