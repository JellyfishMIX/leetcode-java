package no42;

/**
 * 42. 接雨水
 * link: https://leetcode-cn.com/problems/trapping-rain-water/
 *
 * @author JellyfishMIX
 * @date 2021/8/15 19:16
 */
public class Solution {
    public int trap(int[] height) {
        // 判空校验
        if (height == null) {
            return 0;
        }
        // 记录第 i 列左边最高的墙
        int[] leftMaxHeight = new int[height.length];
        // 寻找第 i 列左边最高的墙
        for (int i = 1; i < height.length - 1; i++) {
            leftMaxHeight[i] = Math.max(leftMaxHeight[i - 1],  height[i - 1]);
        }
        // 记录第 i 列右边最高的墙
        int[] rightMaxHeight = new int[height.length];
        for (int i = height.length - 2; i > 0; i--) {
            rightMaxHeight[i] = Math.max(rightMaxHeight[i + 1], height[i + 1]);
        }
        // 总雨水量
        int sum = 0;
        // 开始按列计算雨水
        for (int i = 1; i < height.length - 1; i++) {
            // 取第 i 列 左侧最高墙 和 右侧最高墙 中的小者
            int minHeight = Math.min(leftMaxHeight[i], rightMaxHeight[i]);
            int difference = minHeight - height[i];
            if (difference > 0) {
                sum += difference;
            }
        }
        return sum;
    }
}
