package second.leetcode.no5.second;

/**
 * @author shijie.qian
 * @date 2024/4/7 18:39
 */
public class Solution {
    public String longestPalindrome(String s) {
        String longestHuiWen = "";
        for (int i = 0; i < s.length(); i++) {
            // 回文串为奇
            String result1 = findHuiWen(s, i, i);
            // 回文串为偶
            String result2 = findHuiWen(s, i, i + 1);
            longestHuiWen = result1.length() > longestHuiWen.length() ? result1 : longestHuiWen;
            longestHuiWen = result2.length() > longestHuiWen.length() ? result2 : longestHuiWen;
        }
        return longestHuiWen;
    }

    /**
     * 寻找以left, right 为中心的回文串
     */
    private String findHuiWen(String originalString, int left, int right) {
        while (left >= 0 && right < originalString.length()) {
            if (originalString.charAt(left) == originalString.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }
        }
        return originalString.substring(left + 1, right);
    }
}
