package first.no206;

/**
 * 迭代
 *
 * @author JellyfishMIX
 * @date 2021/8/5 13:49
 */
public class Solution1 {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
