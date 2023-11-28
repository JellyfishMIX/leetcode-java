package second.leetcode.no5;

/**
 * @author shijie.qian
 * @date 2023/11/28 11:31
 */
public class Solution {
    public String longestPalindrome(String s) {
        String longestStr = "";
        for (int i = 0; i < s.length(); i++) {
            // 假设为奇，中点有一个
            String result1 = findPalindrome(s, i, i);
            // 假设为偶，中点有两个
            String result2 = findPalindrome(s, i, i + 1);
            longestStr = result1.length() > longestStr.length() ? result1 : longestStr;
            longestStr = result2.length() > longestStr.length() ? result2 : longestStr;
        }
        return longestStr;
    }

    /**
     * 寻找以 left, right 为中心的回文串
     */
    private String findPalindrome(String originalStr, int left, int right) {
        // 不考虑空
        while (left >= 0 && right < originalStr.length() && originalStr.charAt(left) == originalStr.charAt(right)) {
            left--;
            right++;
        }
        return originalStr.substring(left + 1, right);
    }
}
