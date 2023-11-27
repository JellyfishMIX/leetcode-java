package second.leetcode.no344;

/**
 * @author shijie.qian
 * @date 2023/11/27 13:09
 */
public class Solution2 {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
