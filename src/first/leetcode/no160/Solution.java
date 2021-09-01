package first.leetcode.no160;

/**
 * 160. 相交链表
 * link: https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 *
 * @author JellyfishMIX
 * @date 2021/8/14 10:35
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
