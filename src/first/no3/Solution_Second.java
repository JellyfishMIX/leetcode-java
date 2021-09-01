package first.no3;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * link: https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 双指针滑动窗口算法
 * 题解：https://mp.weixin.qq.com/s/ioKXTMZufDECBUwRRp3zaA
 *
 * @author JellyfishMIX
 * @date 2021/9/1 14:02
 */
public class Solution_Second {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> windowsMap = new HashMap<>();
        // 记录最长无重复字串的长度
        int maxLength = 0;
        // 双指针
        int left = 0, right = 0;
        while (right < s.length()) {
            // 将要移入窗口的字符
            char in = s.charAt(right);
            right++;
            // 更新窗口内的数据
            windowsMap.merge(in, 1, Integer::sum);

            // 判断是否需要收缩窗口
            while (windowsMap.get(in) > 1) {
                // 将要移出窗口的字符
                char out = s.charAt(left);
                left++;
                // 更新窗口内的数据
                windowsMap.merge(out, -1, Integer::sum);
            }
            // 更新结果
            maxLength = Math.max(maxLength, right - left);
        }

        return maxLength;
    }
}
