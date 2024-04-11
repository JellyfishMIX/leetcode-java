package second.leetcode.no3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shijie.qian
 * @date 2024/4/12 02:20
 */
public class Solution {
    private Map<Character, Integer> window = new HashMap<>();

    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int strLength = s.length();
        int maxLength = 0;
        while (right < strLength) {
            char input = s.charAt(right);
            right++;
            window.merge(input, 1, Integer::sum);

            while (window.get(input) > 1) {
                char output = s.charAt(left);
                left++;
                window.merge(output, -1, Integer::sum);
            }
            // 更新结果
            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }
}
