package second.leetcode.no23;

import second.leetcode.common.ListNode;

import java.util.PriorityQueue;

/**
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
    public ListNode mergeKLists(ListNode[] lists) {
        // 不考虑 lists 为 null 的情况
        int k = lists.length;
        // PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(k, (o1, o2) -> (o1.val - o2.val));
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((o1, o2) -> (o1.val - o2.val));
        for (ListNode oneHead : lists) {
            if (oneHead != null) {
                priorityQueue.add(oneHead);
            }
        }

        ListNode dummy = new ListNode();
        ListNode cursor = dummy;
        // 维护 priorityQueue 长度最多为 k
        while (!priorityQueue.isEmpty()) {
            ListNode minHead = priorityQueue.poll();
            cursor.next = minHead;
            if (minHead.next != null) {
                priorityQueue.add(minHead.next);
            }
            // 指针移动
            cursor = cursor.next;
        }
        return dummy.next;
    }
}
