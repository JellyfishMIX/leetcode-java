package second.leetcode.no344;

/**
 * @author shijie.qian
 * @date 2023/11/27 12:59
 */
public class Solution {
    public void reverseString(char[] s) {
        // 不考虑空
        // 长度为奇数偶数
        boolean ou = s.length % 2 == 0;
        // 长度偶数
        if (ou) {
            int right = s.length / 2;
            int left = right - 1;
            while (left != -1) {
                char temp = s[left];
                s[left] = s[right];
                s[right] = temp;
                left--;
                right++;
            }
        } else {
            int left = 0;
            int right = s.length - 1;
            // 长度奇数
            while (left != right) {
                char temp = s[left];
                s[left] = s[right];
                s[right] = temp;
                left++;
                right--;
            }
        }
    }
}
