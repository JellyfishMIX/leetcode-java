package first.leetcode.no234;

import java.util.ArrayList;
import java.util.List;

/**
 * 234. 回文链表
 * link: https://leetcode-cn.com/problems/palindrome-linked-list/
 *
 * @author JellyfishMIX
 * @date 2021/8/29 22:45
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        // 把链表的值复制进数组
        List<Integer> valueList = new ArrayList<>();
        ListNode currentNode = head;
        while (currentNode != null) {
            valueList.add(currentNode.val);
            currentNode = currentNode.next;
        }

        // 首尾双指针向中间走
        int left = 0;
        int right = valueList.size() - 1;
        while (left < right) {
            if (!valueList.get(left).equals(valueList.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
