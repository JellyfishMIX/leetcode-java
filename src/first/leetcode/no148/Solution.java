package first.leetcode.no148;

/**
 * 148. 排序链表
 * link: https://leetcode-cn.com/problems/sort-list/
 * 题解：https://leetcode-cn.com/problems/sort-list/solution/sort-list-gui-bing-pai-xu-lian-biao-by-jyd/
 *
 * @author JellyfishMIX
 * @date 2021/9/24 15:05
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        // base case
        if (head == null || head.next == null) {
            return head;
        }
        // 快慢指针找到中点
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        // 递归拆分
        ListNode left = sortList(head);
        ListNode right = sortList(temp);
        ListNode pointer = new ListNode();
        ListNode dummy = pointer;
        // 开始合并
        while (left != null && right != null) {
            if (left.val < right.val) {
                pointer.next = left;
                left = left.next;
            } else {
                pointer.next = right;
                right = right.next;
            }
            pointer = pointer.next;
        }
        // 剩余的 left 或 right 直接拼接到 pointer 上
        pointer.next = left != null ? left : right;
        return dummy.next;
    }
}
