package first.no76;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 * link: https://leetcode-cn.com/problems/minimum-window-substring/
 * 双指针法
 * 题解：https://mp.weixin.qq.com/s/ioKXTMZufDECBUwRRp3zaA
 *
 * @author JellyfishMIX
 * @date 2021/8/31 16:35
 */
public class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> needMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            needMap.merge(c, 1, Integer::sum);
        }

        // 双指针法
        int left = 0, right = 0;
        // 记录 windowMap 中满足 needMap 条件的字符个数
        int valid = 0;
        // 最小覆盖字串长度
        int length = Integer.MAX_VALUE;
        // 最小覆盖字串起始索引
        int start = 0;
        while (right < s.length()) {
            // 将移入窗口的字符
            char in = s.charAt(right);
            right++;
            // 进行窗口内数据的更新
            if (needMap.containsKey(in)) {
                windowMap.merge(in, 1, Integer::sum);
                if (windowMap.get(in).equals(needMap.get(in))) {
                    valid++;
                }
            }

            // 判断左窗口是否需要收缩
            while (valid == needMap.size()) {
                // 更新最小覆盖子串
                if (right - left < length) {
                    start = left;
                    length = right - left;
                }
                // 将移出窗口的字符
                char out = s.charAt(left);
                left++;
                // 进行窗口内数据的更新
                if (needMap.containsKey(out)) {
                    if (windowMap.get(out).equals(needMap.get(out))) {
                        valid--;
                    }
                    windowMap.merge(out, -1, Integer::sum);
                }
            }
        }
        return length == Integer.MAX_VALUE ? "" : s.substring(start, start + length);
    }
}
