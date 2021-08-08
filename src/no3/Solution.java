package no3;

import java.util.HashSet;
import java.util.Set;

/**
 * @author JellyfishMIX
 * @date 2021/8/6 13:05
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        // 滑动窗口，用来存存储不重复的字符串
        Set<Character> stringSet = new HashSet<>();
        int right = -1;
        int left = 0;
        int longest = 0;
        while (right < length - 1) {
            if (!stringSet.contains(s.charAt(right + 1))) {
                // 窗口右边界伸长 1
                stringSet.add(s.charAt(right + 1));
                right++;
            } else {
                // 窗口左边界收缩 1
                longest = Math.max(longest, stringSet.size());
                stringSet.remove(s.charAt(left));
                left++;
            }
        }
        // 防止没有收缩导致没有触发最长计算，最后进行一次最长计算
        longest = Math.max(longest, stringSet.size());
        return longest;
    }
}
