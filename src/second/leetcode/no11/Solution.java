package second.leetcode.no11;

/**
 * @author shijie.qian
 * @date 2024/3/25 20:50
 */
public class Solution {
    public int maxArea(int[] height) {
        // 不考虑空入参数
        // 双指针解法
        int i = 0;
        int j = height.length - 1;
        int maxArea = 0;
        int currentArea = 0;
        while (i < j) {
            // 总是移动最短边，这样才有可能让当前面积变大
            if (height[i] < height[j]) {
                currentArea = height[i] * (j - i);
                i++;
            } else {
                currentArea = height[j] * (j - i);
                j--;
            }
            maxArea = Math.max(currentArea, maxArea);
        }
        return maxArea;
    }
}
