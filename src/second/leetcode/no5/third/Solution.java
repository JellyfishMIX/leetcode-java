package second.leetcode.no5.third;

/**
 * @author shijie.qian
 * @date 2024/4/24 12:07
 */
public class Solution {
    public String longestPalindrome(String s) {
        String longestHuiwenStr = "";
        for (int i = 0; i < s.length(); i++) {
            // 回文串为奇数
            String str1 = findHuiwen(s, i, i);
            // 回文串为偶数
            String str2 = findHuiwen(s, i, i + 1);
            if (str1.length() > longestHuiwenStr.length()) {
                longestHuiwenStr = str1;
            }
            if (str2.length() > longestHuiwenStr.length()) {
                longestHuiwenStr = str2;
            }
        }
        return longestHuiwenStr;
    }

    /**
     * 寻找以 left 和 right 为中心的回文串, left 和 right 可以重复
     */
    private String findHuiwen(String inputStr, int left, int right) {
        while (left >= 0 && right < inputStr.length()) {
            if (inputStr.charAt(left) == inputStr.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }
        }
        return inputStr.substring(left + 1, right);
    }
}
