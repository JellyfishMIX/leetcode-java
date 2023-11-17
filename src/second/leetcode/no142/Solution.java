package second.leetcode.no142;

import second.leetcode.common.ListNode;

/**
 * @author shijie.qian
 * @date 2023/11/17 10:30
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        boolean flag = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                // 重置 slow 指针为头节点
                slow = head;
                flag = true;
                break;
            }
        }
        if (flag) {
            while (fast != null && slow != null) {
                if (fast == slow) {
                    return slow;
                }
                slow = slow.next;
                fast = fast.next;
            }
        }

        return null;
    }
}
