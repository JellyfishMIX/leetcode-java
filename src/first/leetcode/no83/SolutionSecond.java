package first.leetcode.no83;

/**
 * @author JellyfishMIX
 * @date 2021/10/12 20:18
 */
public class SolutionSecond {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode hair = new ListNode();
        hair.next = head;
        ListNode current = head;
        while (current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return hair.next;
    }
}
