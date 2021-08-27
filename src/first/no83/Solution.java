package first.no83;

/**
 * 83. 删除排序链表中的重复元素
 * link: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 *
 * @author JellyfishMIX
 * @date 2021/8/20 14:53
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
