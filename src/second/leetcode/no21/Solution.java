package second.leetcode.no21;

import second.leetcode.common.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 *
 * @author shijie.qian
 * @date 2023/11/13 19:57
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode dummyCursor = dummy;
        ListNode aCursor = list1;
        ListNode bCursor = list2;
        while (aCursor != null && bCursor != null) {
            if (aCursor.val < bCursor.val) {
                dummyCursor.next = aCursor;
                aCursor = aCursor.next;
            } else {
                dummyCursor.next = bCursor;
                bCursor = bCursor.next;
            }
            dummyCursor = dummyCursor.next;
        }
        if (aCursor != null) {
            dummyCursor.next = aCursor;
        }
        if (bCursor != null) {
            dummyCursor.next = bCursor;
        }
        return dummy.next;
    }
}
