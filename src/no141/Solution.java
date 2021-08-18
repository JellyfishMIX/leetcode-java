package no141;

/**
 * 141. 环形链表
 * link: https://leetcode-cn.com/problems/linked-list-cycle/
 *
 * @author JellyfishMIX
 * @date 2021/8/18 13:45
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while (fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            if (fastPtr == null) {
                return false;
            }
            slowPtr = slowPtr.next;
            if (fastPtr == slowPtr) {
                return true;
            }
        }
        return false;
    }
}
