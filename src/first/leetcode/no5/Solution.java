package first.leetcode.no5;

/**
 * 5. 最长回文子串
 * link: https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 题解：https://mp.weixin.qq.com/s/ux6VSWAPwgOS32xlScr2kQ
 *
 * @author JellyfishMIX
 * @date 2021/9/3 23:51
 */
public class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            // 以 i 为中心，向两侧寻找回文子串
            String s1 = palindrome(s, i, i);
            // 以 [i - 1, i + 1] 为中心，向两侧寻找回文子串
            String s2 = palindrome(s, i, i + 1);
            if (s1.length() > s2.length()) {
                result = result.length() > s1.length() ? result : s1;
            } else {
                result = result.length() > s2.length() ? result : s2;
            }
        }
        return result;
    }

    /**
     * 以 [left, right] 为中心，向两侧寻找回文子串
     *
     * @param str 字符串
     * @param left 左指针
     * @param right 右指针
     * @return 回文字串
     */
    private String palindrome(String str, int left, int right) {
        while (left >= 0 && right < str.length()) {
            if (str.charAt(left) != str.charAt(right)) {
                break;
            }
            left--;
            right++;
        }
        return str.substring(left + 1, right);
    }
}
