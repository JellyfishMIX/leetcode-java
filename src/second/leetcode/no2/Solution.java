package second.leetcode.no2;

import second.leetcode.common.ListNode;

/**
 * @author shijie.qian
 * @date 2024/4/7 14:45
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 注意最后要 return resultHead.next
        ListNode resultHead = new ListNode();
        ListNode resultPointer = resultHead;
        int index = 0;

        ListNode p1 = l1;
        ListNode p2 = l2;
        // 进位
        int carry = 0;
        while (p1 != null || p2 != null) {
            int val1 = 0;
            int val2 = 0;
            if (p1 != null) {
                val1 = p1.val;
            }
            if (p2 != null) {
                val2 = p2.val;
            }
            int currentSum = val1 + val2 + carry;
            int currentDigit = currentSum % 10;
            carry = currentSum / 10;
            ListNode currentNode = new ListNode(currentDigit);
            resultPointer.next = currentNode;
            resultPointer = resultPointer.next;
            if (p1 != null) {
                p1 = p1.next;
            }
            if (p2 != null) {
                p2 = p2.next;
            }
        }

        // 剩余的进位
        if (carry != 0) {
            ListNode currentNode = new ListNode(carry);
            resultPointer.next = currentNode;
            resultPointer = resultPointer.next;
        }
        return resultHead.next;
    }
}
