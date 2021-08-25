package no56;

import java.util.Arrays;

/**
 * 56. 合并区间
 * link: https://leetcode-cn.com/problems/merge-intervals/
 *
 * @author JellyfishMIX
 * @date 2021/8/25 13:18
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        // 先按照区间起始位置排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        // 遍历区间
        int[][] result = new int[intervals.length][2];
        int index = -1;
        for (int[] interval : intervals) {
            // 若 result 为空，或当前区间的起始位置 > result 中最后区间的终止位置，则不合并，在 result 中添加一个新的区间
            if (index == -1 || interval[0] > result[index][1]) {
                result[++index] = interval;
                // 否则合并
            } else {
                // 结束位置为 max(当前区间的终止位置, result 中最后区间的终止位置)
                result[index][1] = Math.max(interval[1], result[index][1]);
            }
        }
        // 返回数组长度为 index + 1
        return Arrays.copyOf(result, index + 1);
    }
}
