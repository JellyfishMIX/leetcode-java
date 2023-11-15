package second.leetcode.no19;

import second.leetcode.common.ListNode;

import java.util.List;

/**
 * @author shijie.qian
 * @date 2023/11/15 21:18
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode nPlus1Node = findReversN(dummy, n + 1);
        nPlus1Node.next = nPlus1Node.next.next;
        return dummy.next;
    }

    private ListNode findReversN(ListNode head, int n) {
        ListNode left = head;
        ListNode right = head;

        for (int i = 0; i < n; i++) {
            right = right.next;
        }

        while (right != null) {
            left = left.next;
            right = right.next;
        }

        return left;
    }
}
