package first.leetcode.no84;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 84. 柱状图中最大的矩形
 * link: https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 * 单调栈
 * 题解：https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/bao-li-jie-fa-zhan-by-liweiwei1419/
 *
 * @author JellyfishMIX
 * @date 2021/9/26 09:20
 */
public class Solution {
    public int largestRectangleArea(int[] heights) {
        // 特殊判断
        if (heights.length == 0) {
            return 0;
        }
        if (heights.length == 1) {
            return heights[0];
        }

        int length = heights.length;
        int[] newHeights = new int[heights.length + 2];
        System.arraycopy(heights, 0, newHeights, 1, length);
        // 单调递增栈
        Deque<Integer> stack = new LinkedList<>();
        // 开头哨兵入栈
        stack.push(0);
        // 更新 newHeights 的长度
        length += 2;
        int maxArea = 0;
        for (int i = 1; i < length; i++) {
            while (newHeights[i] < newHeights[stack.peek()]) {
                int height = newHeights[stack.pop()];
                int width = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, width * height);
            }
            stack.push(i);
        }
        return maxArea;
    }

    @Test
    public void test() {
        int[] heights = {2, 1, 2};
        int result = largestRectangleArea(heights);
        System.out.println(result);
    }
}
