package first.leetcode.no234;

/**
 * 234. 回文链表
 * link: https://leetcode-cn.com/problems/palindrome-linked-list/
 *
 * @author JellyfishMIX
 * @date 2021/9/13 18:12
 */
public class SolutionSecond {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head, slow = head;
        // 快指针 2 步/次，慢指针 2 步/次
        // 慢指针一边走一边把链表前半部分反转
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;

            ListNode temp = slow;
            slow = slow.next;
            temp.next = pre;
            pre = temp;
        }
        // 如果是奇数
        if (fast != null) {
            slow = slow.next;
        }

        while (pre != null && slow != null) {
            if (pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }
}
