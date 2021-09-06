package first.leetcode.no2;

/**
 * 2. 两数相加
 * link: https://leetcode-cn.com/problems/add-two-numbers/
 *
 * @author JellyfishMIX
 * @date 2021/9/6 13:07
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode();
        // 迭代指针
        ListNode cur = dummyHead;
        // 进位标记
        int carry = 0;
        while (l1 != null || l2 != null) {
            // sum = x + y + carry
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            // 运算当前位
            int sum = x + y + carry;
            carry = sum / 10;
            sum = sum % 10;
            // cur 向后移动
            ListNode currentNode = new ListNode(sum);
            cur.next = currentNode;
            cur = currentNode;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        // 有余留进位，再加一个结点
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        // 返回头结点
        return dummyHead.next;
    }
}
