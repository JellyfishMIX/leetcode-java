package no25;

/**
 * 25. K 个一组翻转链表
 * link: https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 *
 * @author JellyfishMIX
 * @date 2021/8/15 23:20
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 判空处理
        if (head == null || head.next == null){
            return head;
        }
        // 伪头节点
        ListNode hair = new ListNode();
        hair.next = head;
        ListNode precursor = hair;
        ListNode end = hair;
        while (end.next != null) {
            // /循环 k 次，找到需要翻转的链表的结尾。这里每次循环要判断 end 是否等于空，因为如果为空，end.next 会报空指针异常。
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            // 剩余不足 k 个，不翻转
            if (end == null) {
                break;
            }
            // 记录下一个 k 组的头节点
            ListNode next = end.next;
            // 从主链表上断掉
            end.next = null;
            ListNode start = precursor.next;
            // 翻转并将头部拼接至主链表上
            precursor.next = reverse(start);
            // 经过翻转后 start 是头节点，end 拼接回主链表
            start.next = next;
            precursor = start;
            end = start;
        }
        return hair.next;
    }

    /**
     * 翻转一个链表
     *
     * @param head 原链表的头节点
     * @return 新的头节点
     */
    private ListNode reverse(ListNode head) {
        // 单链表为空或只有一个节点，直接返回原单链表
        if (head == null || head.next == null){
            return head;
        }
        ListNode precursor = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = precursor;
            precursor = current;
            current = next;
        }
        return precursor;
    }
}
