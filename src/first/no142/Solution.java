package first.no142;

/**
 * 142. 环形链表 II
 * link: https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * 题解：https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/linked-list-cycle-ii-kuai-man-zhi-zhen-shuang-zhi-/
 *
 * @author JellyfishMIX
 * @date 2021/8/19 16:10
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return head;
        }
        // 快慢指针
        ListNode fast = head;
        ListNode slow = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            // 快指针追上了慢指针
            if (fast == slow) {
                break;
            }
        }
        // 快指针回到 head，开始和 slow 共同以 1步/次 的速度走
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        // fast 和 slow 相遇，返回开始入环的第一个节点
        return fast;
    }
}
