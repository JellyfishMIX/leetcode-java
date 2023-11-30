package second.leetcode.no76;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author shijie.qian
 * @date 2023/11/30 23:08
 */
public class Solution {
    public String minWindow(String s, String t) {
        /**
         * key: 窗口内的字符, value: 此字符出现的次数
         */
        Map<Character, Integer> windowCharMap = new HashMap<>();
        /**
         * key: 目标所需的字符, value: 此字符出现的次数
         */
        Map<Character, Integer> needCharMap = new HashMap<>();
        /**
         * key: 窗口中出现的有效字符数, value: 此字符出现的次数
         */
        // Map<Character, Integer> validCharMap = new HashMap<>();

        // 不考虑空
        for (int i = 0; i < t.length(); i++) {
            needCharMap.merge(t.charAt(i), 1, Integer::sum);
        }
        int right = 0;
        int left = 0;
        int start = 0;
        int end = 0;
        int minCoverLength = Integer.MAX_VALUE;
        // 窗口内达标字符数
        int validCharSize = 0;
        while (right < s.length()) {
            // 将要进入窗口的 char
            char in = s.charAt(right);
            // window 扩大
            right++;
            // 维护窗口内 char
            if (needCharMap.containsKey(in)) {
                windowCharMap.merge(in, 1, Integer::sum);
                if (Objects.equals(windowCharMap.get(in), needCharMap.get(in))) {
                    validCharSize++;
                }
            }
            while (validCharSize == needCharMap.size()) {
                // 更新最小覆盖子串
                int currentCoverLength = right - left;
                if (currentCoverLength < minCoverLength) {
                    end = right;
                    start = left;
                    minCoverLength = currentCoverLength;
                }

                // 将要离开窗口的 char
                char out = s.charAt(left);
                // window 缩小
                left++;
                // 维护窗口内 char
                if (needCharMap.containsKey(out)) {
                    if (Objects.equals(windowCharMap.get(out), needCharMap.get(out))) {
                        validCharSize--;
                    }
                    windowCharMap.merge(out, -1, Integer::sum);
                }
            }
        }

        return minCoverLength == Integer.MAX_VALUE ? "" : s.substring(start, end);
    }
}
