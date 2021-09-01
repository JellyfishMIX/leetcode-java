package first.no567;

import java.util.HashMap;
import java.util.Map;

/**
 * 567. 字符串的排列
 * link: https://leetcode-cn.com/problems/permutation-in-string/
 * 双指针滑动窗口算法
 * 题解：https://mp.weixin.qq.com/s/ioKXTMZufDECBUwRRp3zaA
 *
 * @author JellyfishMIX
 * @date 2021/9/1 01:03
 */
public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> needMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();
        for (char c : s1.toCharArray()) {
            needMap.merge(c, 1, Integer::sum);
        }

        // 双指针
        int left = 0, right = 0;
        // 记录 windowMap 中满足 needMap 条件的字符个数
        int valid = 0;
        while (right < s2.length()) {
            // 将移入窗口的字符
            char in = s2.charAt(right);
            right++;
            // 进行窗口内数据的更新
            if (needMap.containsKey(in)) {
                windowMap.merge(in, 1, Integer::sum);
                if (windowMap.get(in).equals(needMap.get(in))) {
                    valid++;
                }
            }

            // 判断左窗口是否需要收缩
            if (right - left >= s1.length()) {
                // 判断是否找到了合法的字串
                if (valid == needMap.size()) {
                    return true;
                }
                // 将移除窗口的字符
                char out = s2.charAt(left);
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

        return false;
    }
}
