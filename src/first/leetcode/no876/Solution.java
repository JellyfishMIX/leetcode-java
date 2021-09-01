package first.leetcode.no876;

/**
 * 876. 链表的中间结点
 * link: https://leetcode-cn.com/problems/middle-of-the-linked-list/
 * 题解：快慢指针，快指针每次走 2 步，慢指针每次走 1 步
 *
 * @author JellyfishMIX
 * @date 2021/8/31 13:44
 */
public class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
