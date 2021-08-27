package first.no11;

/**
 * 11. 盛最多水的容器
 * link: https://leetcode-cn.com/problems/container-with-most-water/
 *
 * @author JellyfishMIX
 * @date 2021/8/22 00:01
 */
public class Solution {
    public int maxArea(int[] height) {
        // 面积
        int resultArea = 0;
        int i = 0;
        int j = height.length - 1;
        // 双指针从两端开始向内收缩
        while (i < j) {
            int currentArea;
            if (height[i] < height[j]) {
                currentArea = (j - i) * height[i];
                i++;
            } else {
                currentArea = (j - i) * height[j];
                j--;
            }
            resultArea = Math.max(resultArea, currentArea);
        }
        return resultArea;
    }
}
