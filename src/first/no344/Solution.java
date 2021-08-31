package first.no344;

/**
 * 344. 反转字符串
 * link: https://leetcode-cn.com/problems/reverse-string/
 *
 * @author JellyfishMIX
 * @date 2021/8/31 15:42
 */
public class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            swap(s, left, right);
            left++;
            right--;
        }
    }

    private void swap(char[] s, int a, int b) {
        char temp = s[a];
        s[a] = s[b];
        s[b] = temp;
    }
}
