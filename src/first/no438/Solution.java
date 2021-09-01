package first.no438;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 438. 找到字符串中所有字母异位词
 * link: https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 * 字母异位词即指定字符串的字母全排列。使用双指针滑动窗口算法。
 * 题解：https://mp.weixin.qq.com/s/ioKXTMZufDECBUwRRp3zaA
 *
 * @author JellyfishMIX
 * @date 2021/9/1 13:07
 */
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> needMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();
        for (char c : p.toCharArray()) {
            needMap.merge(c, 1, Integer::sum);
        }

        // 双指针
        int left = 0, right = 0;
        // 记录窗口中的字符满足 needMap 中条件的字符个数
        int valid = 0;
        List<Integer> result = new ArrayList<>();
        while (right < s.length()) {
            // 将要移入窗口的字符
            char in = s.charAt(right);
            right++;
            // 更新窗口内数据
            if (needMap.containsKey(in)) {
                windowMap.merge(in, 1, Integer::sum);
                if (windowMap.get(in).equals(needMap.get(in))) {
                    valid++;
                }
            }

            // 判断是否收缩窗口
            while (right - left >= p.length()) {
                // 判断是否符合结果
                if (valid == needMap.size()) {
                    result.add(left);
                }

                // 将要移除窗口的字符
                char out = s.charAt(left);
                left++;
                // 更新窗口内数据
                if (needMap.containsKey(out)) {
                    if (windowMap.get(out).equals(needMap.get(out))) {
                        valid--;
                    }
                    windowMap.merge(out, -1, Integer::sum);
                }
            }
        }

        return result;
    }
}
