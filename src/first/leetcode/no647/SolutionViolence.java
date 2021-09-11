package first.leetcode.no647;

/**
 * 647. 回文子串
 * link: https://leetcode-cn.com/problems/palindromic-substrings/
 *
 * @author JellyfishMIX
 * @date 2021/9/11 08:39
 */
public class SolutionViolence {
    public int countSubstrings(String s) {
        // 回文字串的个数
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (isPalindrome(s.substring(i, j))) {
                    result++;
                }
            }
        }
        return result;
    }

    private boolean isPalindrome(String str) {
        int length = str.length();
        // 空字符串特判
        if (length == 0) {
            return false;
        }
        int middle = length / 2;
        int left = 0, right = 0;

        // 奇数长度的字符串检验是否是回文串
        if (str.length() % 2 == 1) {
            left = middle;
            right = middle;
            // 偶数长度的字符串检验是否是回文串
        } else {
            left = middle - 1;
            right = middle;
        }
        return isPalindrome(str, left, right);
    }

    private boolean isPalindrome(String str, int left, int right) {
        while (left >= 0 && right < str.length()) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left--;
            right++;
        }
        return true;
    }
}
